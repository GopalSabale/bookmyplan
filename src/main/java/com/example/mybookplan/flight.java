package com.example.mybookplan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fighter_jet {

    @GetMapping("/fighter_jet")
    public String getData() {
<<<<<<< HEAD
        return "Hello Welcome to BookMyPlan, Please book  fighter_jet at 20% discount";
=======
        return "Hello Welcome to BookMyPlan, Please book  fighter_jet at 30% discount";
>>>>>>> 5bfbfb52287cbd936f52b40fb01defb6747624b8
    }
}
