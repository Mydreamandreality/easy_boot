package com.geek.conding.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @GetMapping(value = "/hello/{name}")
    public String Index(@PathVariable("name") String name) {
        return "hello" + name;
    }
}
