package com.kbstar.controller;

import com.kbstar.dto.Cust;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center","login");
        return "index";
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd){
//        System.out.println();   => 이 형식 절대 사용하지 않기 . Logger 사용하기
        logger.info("----------"+ id + " " +pwd);
        // root level 을 error로 바꾸면 출력 안됨. 그래도 확인 완료 후 지워주기
        model.addAttribute("center","login");
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center","register");
        return "index";
    }

    @RequestMapping("/registerimpl")
    //public String registerimpl(Model model, String id, String pwd, String name){
        //logger.info("----------"+id + " " +pwd + " " + name);
    //항목이 많아지면 custDTO 활용

    public String registerimpl(Model model, Cust cust){
        logger.info("----------"+ cust.toString());

        //
        model.addAttribute("rcust", cust);
        model.addAttribute("center","registerok");
        return "index";
    }

    // /quics?page=bs01
    @RequestMapping("/quics")
    public String quics(String page){
        return page;
    }

}
