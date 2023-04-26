package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class InsertTest {

    @Autowired
    CustService service;
    @Test
    void contextLoads() {
        Cust obj = new Cust("id01", "pwd01", "james");
        //service.register(obj);  ->예외처리 try/catch
        try {
            service.register(obj);
        } catch (Exception e) {
            log.info("등록 에러..");
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

}
