package com.kbstar.service;

import com.kbstar.dto.Cust;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.CustMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j  //log
@Service
public class CustService implements KBService<String, Cust> {

    @Autowired
    CustMapper mapper;


    @Override
    public void register(Cust cust) throws Exception {
        mapper.insert(cust); //login table db에 집어넣고
        mapper.insert(cust); //다른 테이블에도 넣어줌  -> 만약 두번째 작업에 오류가 있다면 첫번째 정상처리분도 되돌려야 => 롤백
        log.info("Send Mail..."+cust.getId());
    }

    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(Cust cust) throws Exception {
        mapper.update(cust);
    }

    @Override
    public Cust get(String s) throws Exception {

        return mapper.select(s);
    }

    @Override
    public List<Cust> get() throws Exception {
        return mapper.selectall();
    }
}
