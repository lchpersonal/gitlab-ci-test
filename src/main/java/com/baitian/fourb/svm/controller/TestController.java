package com.baitian.fourb.svm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String verifyConnect(@RequestBody ArrayList<User> list) {
        System.out.println("test===========================");
        return "Success";
    }

    //final User[] list = new User[3];

    @RequestMapping("/test1")
    @ResponseBody
    public String verifyConnect1(String[] list) {
        System.out.println("test1===========================");
        return "Success";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String verifyConnect2(UserWrapper users) {
        System.out.println("test2===========================");
        return "Success";
    }


    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
