package com.kbstar.controller;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import com.kbstar.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MainController {

    @Value("${adminserver}")
    String adminserver;

    @Autowired
    private BCryptPasswordEncoder encoder;
    //암호화

    @Autowired
    CustService custService;

    //Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @RequestMapping("/")
    public String main(Model model) throws Exception{
        String result;
        result = WeatherUtil.getWeather1("109");
        model.addAttribute("weatherinfo",result);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center","login");
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session){
        if(session != null){
            session.invalidate();
        }
        return "index";
    }

    @RequestMapping("/custinfo")
    public String custinfo(Model model, String id) throws Exception {
        Cust cust = null;
        //cust =custService.get(id);
        try {
            cust =custService.get(id);
        } catch (Exception e) {
            throw new Exception("시스템장애");
        }
        model.addAttribute("custinfo",cust);
        model.addAttribute("center","custinfo");
        return "index";
    }

    @RequestMapping("/custinfoimpl")
    public String custinfoimpl(Model model, Cust cust) throws Exception {
        try {
            log.info("-------------------------------------" +cust.getPwd());
            cust.setPwd(encoder.encode(cust.getPwd()));
            custService.modify(cust);
        } catch (Exception e) {
            throw new Exception("시스템장애");
        }
        //수정이 끝나면 custinfo 화면으로 보낸다
        return "redirect:/custinfo?id="+cust.getId();
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd,
                            HttpSession session) throws Exception {
                            //로그인 성공하면 session 사용해라
        //logger.info("------------------------------"+id+" "+pwd);
        Cust cust = null;
        //cust =custService.get(id); //try/catch
        String nextPage = "loginfail";
        try {
            cust =custService.get(id);
            if(cust != null && encoder.matches(pwd, cust.getPwd())){
                // ==null : 아이디가 틀렸어  !=null 아이디까지는 성공
                //pwd는 입력된 패스워드. cust.getPwd 암호화된 패스워드 일치하는지 확인
                //&&앞에꺼실패하면 끝. &하나는 앞뒤 다 비교
                // true 나오면 로그인성공
                nextPage = "loginok";
                session.setMaxInactiveInterval(100000); //로그인유지시간
                session.setAttribute("logincust",cust);
                //session에 logincust를 넣어줌. 모델에 담은것처럼 세션에 담은것도 $사인으로 꺼낼 수 있다

            }
        } catch (Exception e) {
            throw new Exception("시스템 장애 : 잠시 후 다시 로그인 하세요");
        }

        model.addAttribute("center",nextPage);
        return "index";
    }
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model,
                               Cust cust, HttpSession session) throws Exception {
        //custService.register(cust);
        try {
            cust.setPwd(encoder.encode(cust.getPwd()));
            //화면에서 입력된 암호를 가져와서 암호화 후 다시 암호로 집어넣는다
            custService.register(cust);
            session.setAttribute("logincust",cust);
        } catch (Exception e) {
            throw new Exception("가입오류");
        }
        //logger.info("----------------"+ cust.toString());
        model.addAttribute("rcust", cust);
        model.addAttribute("center","registerok");
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center","register");
        return "index";
    }


    // /quics?page=bs01
    @RequestMapping("/quics")
    public String quics(String page){
        return page;
    }

    //pic
    @RequestMapping("/pic")
    public String pic(Model model){
        model.addAttribute("center","pic");
        return "index";
    }


    //websocket
    @RequestMapping("/websocket")
    public String websocket(Model model){
        model.addAttribute("adminserver", adminserver);
        model.addAttribute("center","websocket");
        return "index";
    }



}
