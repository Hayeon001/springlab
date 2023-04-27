package com.kbstar.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Sales {
    private String rdate; //2023-01-02
    private int price;
    private String gender;

//    public Sales(int price, String gender) {
//        this.price = price;
//        this.gender = gender;
//    }
}
