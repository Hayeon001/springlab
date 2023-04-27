package com.kbstar.service;

import com.kbstar.dto.Adm;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.AdmMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdmService implements KBService <String, Adm> {

    @Autowired
    AdmMapper mapper;

    @Override
    public void register(Adm adm) throws Exception {
        mapper.insert(adm); //다른 테이블에도 넣어줌  -> 만약 두번째 작업에 오류가 있다면 첫번째 정상처리분도 되돌려야 => 롤백
        log.info("Send Mail..."+adm.getId());
    }

    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(Adm adm) throws Exception {
        mapper.update(adm);
    }

    @Override
    public Adm get(String s) throws Exception {
        return mapper.select(s);
    }

    @Override
    public List<Adm> get() throws Exception {
        return mapper.selectall();
    }
}
