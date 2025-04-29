package com.cg.user_info.controller;

import com.cg.user_info.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/")
    public String showPage1(HttpSession session, Model model) {
        model.addAttribute("sessionId", session.getId());
        return "page1";
    }

    @PostMapping("/page2")
    public String processPage1(@ModelAttribute("user") User user,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               HttpSession session, Model model) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        model.addAttribute("sessionId", session.getId());
        return "page2";
    }

    @PostMapping("/page3")
    public String processPage2(@ModelAttribute("user") User user,
                               @RequestParam("email") String email,
                               @RequestParam("phone") String phone,
                               HttpSession session, Model model) {
        user.setEmail(email);
        user.setPhone(phone);
        model.addAttribute("sessionId", session.getId());
        return "page3";
    }

    @PostMapping("/page4")
    public String processPage3(@ModelAttribute("user") User user,
                               @RequestParam("city") String city,
                               @RequestParam("country") String country,
                               HttpSession session, Model model) {
        user.setCity(city);
        user.setCountry(country);
        model.addAttribute("sessionId", session.getId());
        return "page4";
    }
}
