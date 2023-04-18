package com.kbstar.tv;

import com.kbstar.frame.TV;

public class LTV implements TV {

    @Override
    public void trunOn() {
        System.out.println("LTV Turn On");
    }

    @Override
    public void trunOff() {
        System.out.println("LTV Turn Off");
    }
}
