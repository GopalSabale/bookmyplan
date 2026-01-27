package com.example.mybookplan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hotel {

    @GetMapping("/hotel")
    public String getData() {
        return "Hello Welcome to BookMyPlan, Please book  hotel at 20% discount";
    }
}
