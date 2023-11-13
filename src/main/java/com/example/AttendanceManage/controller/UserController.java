package com.example.AttendanceManage.controller;

import com.example.AttendanceManage.entity.User;
import com.example.AttendanceManage.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    UserRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/user")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("user_list");
        Iterable<User> list = repository.findAll();
        mav.addObject("data",list);
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView userNew(ModelAndView mav){
        mav.setViewName("new");
        return mav;
    }

    @PostMapping("/new")
    @Transactional
    public ModelAndView userNew(@ModelAttribute("formModel") User User, ModelAndView mav){
        repository.saveAndFlush(User);
        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView userEdit(@ModelAttribute("formModel") User User, @PathVariable int id, ModelAndView mav){
        mav.setViewName("edit");
        Optional<User> data = repository.findById(id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @PostMapping("/edit")
    @Transactional
    public ModelAndView userUpdate(@ModelAttribute User User, ModelAndView mav){
        repository.saveAndFlush(User);
        return new ModelAndView("redirect:/user");
    }
}
