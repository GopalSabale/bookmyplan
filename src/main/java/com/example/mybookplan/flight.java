package com.example.mybookplan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fligher {

    @GetMapping("/fighter")
    public String getData() {
<<<<<<< HEAD
        return "Hello Welcome to BookMyPlan, Please book  fighter at 20% discount";
=======
        return "Hello Welcome to BookMyPlan, Please book  fighter at 30% discount";
>>>>>>> 5bfbfb52287cbd936f52b40fb01defb6747624b8
    }
}
