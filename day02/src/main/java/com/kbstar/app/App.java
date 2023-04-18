package com.kbstar.app;

import com.kbstar.frame.*;
import com.kbstar.tv.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String args[]){
        //바꿔야하는 부분. 순방향
        //TV tv = new STV();
        //tv.trunOn();
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");

        TV tv = (TV) factory.getBean("stv");
        tv.trunOn();
    }
}
