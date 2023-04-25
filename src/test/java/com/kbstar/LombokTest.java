package com.kbstar;

import com.kbstar.dto.Cust;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LombokTest {

    //int i=10;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Test
    void contextLoads(){
        //System.out.println("Result:"+i);
        Cust cust = new Cust("id01", "pwd01","이말숙");
        logger.info(cust.toString());

    }

}
