package com.kbstar;

import com.kbstar.dto.CustDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Web04ApplicationTests {

    @Test
    void contextLoads() {
        CustDTO cust = new CustDTO("id01", "pwd01","이말숙");
        System.out.println(cust.toString());
    }

}
