package com.kbstar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;


@Getter
@AllArgsConstructor
@ToString
public class Cart {
    private int id;
    private String custId;
    private int itemId;
    private int cnt;
    private Date rdate;

    //insert : 3개만 들어가는 constructor
    public Cart(String custId, int itemId, int cnt) {
        this.custId = custId;
        this.itemId = itemId;
        this.cnt = cnt;
    }

    //update
    public Cart(int id, String custId, int itemId, int cnt) {
        this.id = id;
        this.custId = custId;
        this.itemId = itemId;
        this.cnt = cnt;
    }

    //select 할 떄 필요한 내용
    private String cust_name;
    private String item_name;
    private int item_price;
    private String item_imgname;

//    public Cart(int id, String custId, int itemId, int cnt) {
//        this.id = id;
//        this.custId = custId;
//        this.itemId = itemId;
//        this.cnt = cnt;
//    }
}
