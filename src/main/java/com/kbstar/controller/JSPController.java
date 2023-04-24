package com.kbstar.controller;

import com.kbstar.dto.Cust;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/jsp")
public class JSPController {
    //cust 눌렀을 때 나오는 부분
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());


    String dir = "jsp/";

    //127.0.0.1/jsp
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }

//    @RequestMapping("")
//    public String main(Model model){
//        model.addAttribute("left","jsp/left");
//        model.addAttribute("center","jsp/center");
//        return "index";
//    }


    @RequestMapping("/jsp01")
    public String jsp01(Model model){
        model.addAttribute("num",1000.234);  //소숫점
        //model.addAttribute("num",1000);
        Cust cust = new Cust("id01","pwd01","<a href=''>K</a>");  //링크가 노출되면 해킹위험
        //Cust cust = new Cust("id01","pwd01","이말숙");  //한글
        //Cust cust = new Cust("id01","pwd01","James");  //영어
        model.addAttribute("cust", cust);

        Date date = new Date();
        model.addAttribute("cdate", date);

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp01");
        return "index";
    }

    @RequestMapping("/jsp02")
    public String jsp02(Model model){
        Cust cust = new Cust("id01","pwd01","James");
        model.addAttribute("rcust", cust);
        model.addAttribute("num",1);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp02");
        return "index";
    }
    @RequestMapping("/jsp03")
    public String jsp03(Model model){
        //데이터 없어서 만들기
        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01","pwd01","James1"));
        list.add(new Cust("id02","pwd02","James2"));
        list.add(new Cust("id03","pwd03","James3"));
        list.add(new Cust("id04","pwd04","James4"));
        list.add(new Cust("id05","pwd05","James5"));
        model.addAttribute("clist",list);
        //담은 데이터를 dir+"jsp03"의 jsp03에 뿌리기/ //table형태로

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp03");
        return "index";
    }

    @RequestMapping("/jsp04")
    public String jsp04(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp04");
        return "index";
    }

    @RequestMapping("/jsp05")
    public String jsp05(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp05");
        return "index";
    }





}
