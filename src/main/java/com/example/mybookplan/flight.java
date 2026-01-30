package com.example.mybookplan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class flight {

    @GetMapping("/hotel")
    public String getData() {
        return "Hello Welcome to BookMyPlan, Please book  flight at 20% discount";
    }
}
