package com.n0sense.springbootfilter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {
    @GetMapping("/hello/{name}")
    public String print(@PathVariable String name) {
        return "Hello, " + name;
    }
}
