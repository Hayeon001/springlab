package com.kbstar.controller;

import com.kbstar.dto.Ncp;
import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.CFRFaceUtil;
import com.kbstar.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class NcpController {

    @Value("${uploadimgdir}")
    String imgpath;

    @RequestMapping("/cfr1impl")
    public String cfr1impl(Model model, Ncp ncp) throws ParseException {  //Ncp에 이미지 파일덩어리가 올라와 있다
        //1.올라온 이미지를 서버에 파일 저장
            FileUploadUtil.saveFile(ncp.getImg(), imgpath); //ncp의 img에서 get, imgpath : 저장할 위치

        //2.저장한이미지를 ncp에 물어본다
            //String imgname = "jung.jpg";
            String imgname = ncp.getImg().getOriginalFilename(); // ncp.getImg() 이미지 덩어리에서 파일이름 가져와
            JSONObject result = (JSONObject) CFRCelebrityUtil.getResult(imgpath,imgname);  //서버에 전송. result결과를 줌
            log.info(result.toJSONString());

            //결과 : {"faces":[{"celebrity":{"confidence":0.668766,"value":"이동욱"}}],"info":{"size":{"width":1200,"height":800},"faceCount":1}}
            //결과에서 닮은 연예인 이름만 추출하기
            JSONArray faces = (JSONArray) result.get("faces");
            JSONObject obj = (JSONObject) faces.get(0);  //배열에서 0번째
            JSONObject celebrity = (JSONObject) obj.get("celebrity");
            String value = (String) celebrity.get("value"); //value를 꺼내면 String이 나옴

        //3.결과도출
            model.addAttribute("result",value);
            model.addAttribute("center","cfr1");

        return "index";
    }


    @RequestMapping("/cfr2impl")
    public String cfr1imp2(Model model, Ncp ncp) throws ParseException {  //Ncp에 이미지 파일덩어리가 올라와 있다
        //1.올라온 이미지를 서버에 파일 저장
        FileUploadUtil.saveFile(ncp.getImg(), imgpath); //ncp의 img에서 get, imgpath : 저장할 위치

        //2.저장한이미지를 ncp에 물어본다
        //String imgname = "jung.jpg";
        String imgname = ncp.getImg().getOriginalFilename(); // ncp.getImg() 이미지 덩어리에서 파일이름 가져와
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath,imgname);  //서버에 전송. result결과를 줌
        log.info(result.toJSONString());

        //emotion //gender //pose //age
        String emotion_value ="";
        String gender_value ="";
        String pose_value ="";
        String age_value = "";

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);  //배열에서 0번째

        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String) emotion.get("value"); //value를 꺼내면 String이 나옴

        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String) gender.get("value"); //value를 꺼내면 String이 나옴

        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String) pose.get("value"); //value를 꺼내면 String이 나옴

        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String) age.get("value"); //value를 꺼내면 String이 나옴

        //값이 여러개일때 Map에 담기
        Map<String,String> map =new HashMap<>();
        map.put("emotion",emotion_value);
        map.put("gender",gender_value);
        map.put("pose",pose_value);
        map.put("age",age_value);



        //3.결과도출
        model.addAttribute("result", map);
        model.addAttribute("center","cfr2");

        return "index";
    }

    @RequestMapping("/mycfr")
    public String mycfr(Model model, String imgname) throws ParseException {  //Ncp에 이미지 파일덩어리가 올라와 있다
        //1.이미지 이미 저장되어 있음

        //2.저장한이미지를 ncp에 물어본다
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath,imgname);  //서버에 전송. result결과를 줌
        log.info(result.toJSONString());

        //emotion //gender //pose //age
        String emotion_value ="";
        String gender_value ="";
        String pose_value ="";
        String age_value = "";

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);  //배열에서 0번째

        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String) emotion.get("value"); //value를 꺼내면 String이 나옴

        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String) gender.get("value"); //value를 꺼내면 String이 나옴

        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String) pose.get("value"); //value를 꺼내면 String이 나옴

        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String) age.get("value"); //value를 꺼내면 String이 나옴

        //값이 여러개일때 Map에 담기
        Map<String,String> map =new HashMap<>();
        map.put("emotion",emotion_value);
        map.put("gender",gender_value);
        map.put("pose",pose_value);
        map.put("age",age_value);



        //3.결과도출
        model.addAttribute("result", map);
        model.addAttribute("center","pic");

        return "index";
    }

}
