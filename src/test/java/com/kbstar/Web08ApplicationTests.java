package com.kbstar;

import com.kbstar.dto.Cust;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Web08ApplicationTests {

    @Test
    void contextLoads() {
        Cust cust = new Cust("id01", "pwd01","이말숙");
        System.out.println(cust.toString());
    }

}
