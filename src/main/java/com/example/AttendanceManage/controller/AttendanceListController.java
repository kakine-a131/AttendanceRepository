package com.example.AttendanceManage.controller;

import com.example.AttendanceManage.entity.Attendance;
import com.example.AttendanceManage.repositories.AttendanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class AttendanceListController {

    @Autowired
    AttendanceRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/attendanceList")
    public ModelAndView attendanceList(ModelAndView mav){
        mav.setViewName("attendance_list");
        Iterable<Attendance> list = repository.findAll();
        mav.addObject("data",list);
        return mav;
    }

    @GetMapping("/attendance")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("attendance");
        return mav;
    }

    @GetMapping("/start")
    @Transactional
    public String index(@ModelAttribute("formModel") Attendance Attendance, ModelAndView mav){
        Attendance data = new Attendance();
        Date now = new Date();
        data.setId(16);
        data.setUserId(1);
        data.setBeginTime(now);
        data.setStatus("出勤中");
        repository.saveAndFlush(data);
        return "redirect:attendanceList";
    }
}
