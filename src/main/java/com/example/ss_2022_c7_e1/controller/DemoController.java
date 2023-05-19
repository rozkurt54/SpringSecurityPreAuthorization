package com.example.ss_2022_c7_e1.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/demo1")
    @PreAuthorize("hasAuthority('read')")
    public String demo1() {
        return "Demo1";
    }


    @GetMapping("/demo2")
    @PreAuthorize("hasAuthority('write')")
    public String demo2() {
        return "Demo2";
    }

    @GetMapping("/demo3")
    @PreAuthorize("permitAll()")
    public String demo3() {
        return "Demo3";
    }

    // @PostFilter
    


}
