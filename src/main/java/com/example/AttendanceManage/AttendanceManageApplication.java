package com.example.AttendanceManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class AttendanceManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManageApplication.class, args);
	}

	@RequestMapping("/login")
	public ModelAndView index(ModelAndView mav){
		mav.setViewName("login");
		return  mav;
	}

	@GetMapping("attendance")
	public ModelAndView attendance(ModelAndView mav){
		mav.setViewName("attendance");
		return mav;
	}


}
