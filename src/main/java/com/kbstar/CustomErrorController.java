package com.kbstar;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorController {
    @ExceptionHandler(Exception.class)
    public String except(Exception e, Model model){
        e.printStackTrace();
        model.addAttribute("msg",e.getMessage());
        model.addAttribute("center","error/error_page1");
        return "index";

        //("시스템장애 : ER0001")에러 발생하면 다 여기서 받아
    }
}