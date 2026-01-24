package com.example.mybookplan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class metro {

    @GetMapping("/metro")
    public String getData() {
        return "Hello Welcome to BookMyPlan, Please book  metro at 10% discount";
    }
}
