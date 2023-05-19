package com.example.ss_2022_c7_e1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/demo/demo3")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .authorizeHttpRequests()
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var u1 = User.withUsername("john")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                .build();

        var u2 = User.withUsername("bill")
                .password(passwordEncoder().encode("12345"))
                .authorities("write")
                .build();


        var uds = new InMemoryUserDetailsManager();
        uds.createUser(u1);
        uds.createUser(u2);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
