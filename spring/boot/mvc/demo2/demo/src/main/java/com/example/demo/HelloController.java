package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Controller
public class HelloController {

    @Autowired
    private SessionData sessionData;

    @Autowired
    private RequestData requestData;

    private Map<Integer, AppUser> store = new HashMap<Integer, AppUser>();

    public HelloController() {
        AppUser user1 = new AppUser(1, "piyush", "123", 27);
        store.put(1, user1);
        AppUser user2 = new AppUser(2, "dipuraj", "123", 28);
        store.put(2, user2);
        AppUser user3 = new AppUser(3, "sadique", "123", 29);
        store.put(3, user3);

    }

    public AppUser fetchById(int userId) {
        System.out.println("***inside fetchById");
        return store.get(userId);
    }

    public AppUser getLoggedInUser() {
        System.out.println("****inside getloggedinuser");
        AppUser user = requestData.getSignedInAppUser();
        if (user == null) {
            user = fetchById(sessionData.getUserId());
            requestData.setSignedInAppUser(user);
        }
        return user;
    }


    boolean credentialsCorrect(int id, String password) {
        AppUser user = store.get(id);
        return (user.getId() == id && password.equals(user.getPassword()));
    }


    @GetMapping("/welcome")
    public String welcomeMessage(Model model) {
        String message = "welcome to webmvc 3";
        model.addAttribute("msg",message);
        //ModelAndView modelAndView = new ModelAndView("welcomepage", "msg", message);
        //return modelAndView;
        return "welcomepage";
    }

    @GetMapping("/getuser")
    public String fetchUser() {
        return "getuserpage";
    }

    @GetMapping("/processGetUser")
    public String profilePage(Model model, @RequestParam("id") int id) {
        if (id < 1) {
            String validationErr = "is can't be zero or smaller than zero";
            model.addAttribute("idErr", validationErr);
            return "getuserpage";
        }

        AppUser user = store.get(id);
        model.addAttribute("user", user);
        return "profilepage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/processLogin")
    public String processLogin(@RequestParam("id") int id, @RequestParam("password") String password, Model model) {
        boolean credentials = credentialsCorrect(id, password);
        if (!credentials) {
            return "login";
        }
        sessionData.setUserId(id);
        doWorkOnLoginUser1();
        doWorkOnLoginUser1();
        doWorkOnLoginUser2();
        doWorkOnLoginUser2();
        AppUser user = getLoggedInUser();
        model.addAttribute("user", user);
        return "profilepage";
    }

    @GetMapping("/home")
    public String home(Model model) {
        AppUser user = getLoggedInUser();
        doWorkOnLoginUser1();
        doWorkOnLoginUser1();
        doWorkOnLoginUser2();
        doWorkOnLoginUser2();

        model.addAttribute("user", user);
        return "profilepage";
    }

    public void doWorkOnLoginUser1() {
        System.out.println("*****doWorkOnLoginUser1");
        AppUser user = getLoggedInUser();
        System.out.println("working on signed in user " + user.getId() + "-" + user.getName());
    }

    public void doWorkOnLoginUser2() {
        System.out.println("*****doWorkOnLoginUser2");
        AppUser user = getLoggedInUser();
        System.out.println("working on signed in user " + user.getId() + "-" + user.getName());
    }


    @GetMapping("/counter")
    public String incrementCounter(Model model) {
        int counter = sessionData.getCounter();
        model.addAttribute("counter", counter);
        sessionData.incrementCounter();
        return "counter";
    }

    @GetMapping("/users/all")
    public String fetchAllUsers(Model model) {
        Collection<AppUser> users = store.values();
        model.addAttribute("users", users);
        return "listusers";
    }


}
