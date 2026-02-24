package com.example.mybookplan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class railway {

    @GetMapping("/railway")
    public String getData() {
        return "Hello Welcome to BookMyPlan, Please book  railway at 10% discount";
    }
}
