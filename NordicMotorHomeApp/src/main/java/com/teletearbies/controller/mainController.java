package com.teletearbies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/overview")
    public String overview(){
        return "overview";
    }



}
