package net.proselyte.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @Autowired
    public MainController() {
    }

    @GetMapping("/")
    public String root(){
        return "root";
    }


}
