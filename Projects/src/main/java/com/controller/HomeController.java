package com.controller;

import com.dao.OperationsDAO;
import com.model.Transfer;
import com.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private OperationsDAO operationsDAO;

    public HomeController(OperationsDAO operationsDAO) {
        this.operationsDAO = operationsDAO;
    }

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/index")
    public ModelAndView loanHome() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @PostMapping("/user")
    public ModelAndView loadUser(ModelAndView model) {
        List<Users> users = operationsDAO.getAllUsers();
        model.addObject("users", users);
        model.setViewName("user");
        return model;
    }

    @PostMapping("/credit")
    public ModelAndView transferCreditCredit(ModelAndView mv, ModelMap model, Users user){

        System.out.println("inside /credit");
        System.out.println("from : " + user.getName());
        System.out.println("Credits: " + user.getCreditAmount());



        model.addAttribute("credit", user.getCreditAmount());
        model.addAttribute("fullName", user.getName());

        List<Users> users = operationsDAO.getAllUsers();
        users.removeIf(usr -> usr.getName().equalsIgnoreCase(user.getName()));
        mv.addObject("toUsers", users);
        mv.setViewName("transfer");
        return mv;
    }

    @GetMapping("credit/${temp.name}")
    public ModelAndView transferCredit(ModelAndView model, @PathVariable("fullName") String fullName) {


     List<Users> user = operationsDAO.getUser(fullName);
     for (Users u: user) {
     model.addObject("credit",u.getCredits());
     }
     List<Users> allUsers = operationsDAO.getAllUsers();
     for (Users u: allUsers) {
     model.addObject("fullName", fullName);
     }

     model.setViewName("transfer");

    return model;
    }

    @GetMapping("/submitCredit")
    public String send(ModelMap model, Users user) {

        operationsDAO.updateTransaction(user.getName(), user.getToUser(), user.getCreditToSend());
        operationsDAO.updateFromUser(user.getName(), user.getCreditToSend());
        operationsDAO.updateToUser(user.getToUser(), user.getCreditToSend());

        List<Users> usr = operationsDAO.getUser(user.getName());
        for (Users u: usr
        ) {
            long balance =  u.getCredits();
            System.out.println("balance" + balance);
            model.addAttribute("balance", balance);
        }

        return "success";

    }



}
