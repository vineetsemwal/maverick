package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @Autowired
    private CustomSession session;

    @Autowired
    private RequestScopeDetails request;

    @Autowired
    private Util util;

    @GetMapping("/welcome")
    public String welcomeMethod(Model model){
        String message="Welcome to spring webmvc";
        model.addAttribute("msg",message);
        return "welcomepage";
    }

    @GetMapping("/userinfo")// ?username=xyz
    public String userInfo(Model model,@RequestParam("username") String username){
        System.out.println("username ="+username);
        User user=new User();
        user.setUsername(username);
        request.setUser(user);
        util.logRequestDetails();
        model.addAttribute("user",user);
        return "userpage";
    }


    @GetMapping("/usercounter")
    public String userCounter(Model model){
        if(session.getUser()==null){
            session.setUser(new User());
        }
        session.getUser().setCounter(session.getUser().getCounter()+1);
        model.addAttribute("user", session);
        return "countpage";
    }
/*
    @GetMapping("/welcome")
    public ModelAndView welcomeMethod2(){
        String message="Welcome to spring webmvc";
        ModelAndView mv=new ModelAndView("welcomepage","msg",message);
      //  model.addAttribute("msg",message);
        return mv;
    }*/

}
