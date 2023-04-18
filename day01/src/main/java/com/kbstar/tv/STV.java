package com.kbstar.tv;

import com.kbstar.frame.TV;

public class STV implements TV {
    //삼성티비

    @Override
    public void trunOn() {
        System.out.println("STV Turn On");
    }

    @Override
    public void trunOff() {
        System.out.println("STV Turn Off");
    }
}
