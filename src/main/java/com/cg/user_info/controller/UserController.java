package com.cg.user_info.controller;

import com.cg.user_info.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

    @GetMapping("/")
    public String showPage1(){
        return "page1";
    }

    @PostMapping("/page2")
    public String processPage1(@ModelAttribute("user") User user, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return "page2";
    }

    @PostMapping("/page3")
    public String processPage2(@ModelAttribute("user") User user, @RequestParam("email") String email, @RequestParam("phone") String phone){
        user.setEmail(email);
        user.setPhone(phone);
        return "page3";
    }

    @PostMapping("/page4")
    public String processPage3(@ModelAttribute("user") User user, @RequestParam("city") String city, @RequestParam("country") String country){
        user.setCity(city);
        user.setCountry(country);
        return "page4";
    }
}
