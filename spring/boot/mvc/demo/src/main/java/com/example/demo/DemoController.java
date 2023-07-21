package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/welcome")
    public String welcomeMethod(Model model){
        String message="Welcome to spring webmvc";
        model.addAttribute("msg",message);
        return "welcomepage";
    }


}
