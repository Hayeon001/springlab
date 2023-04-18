package com.kbstar.service;

import com.kbstar.dao.OracleDao;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;

import java.util.List;

public class BankingService implements MyService<String, UserDTO> {

    MyDao<String, UserDTO> dao;

    //오라클 dao를 활용해서 insert작업 진횅

    public BankingService(){
        //spring 이용 전. 순방향  -> 오라클 안쓰고 다른거 쓰려면 코드 수정해야함
        dao = new OracleDao();
    }

    @Override
    public void register(UserDTO userDTO) {
        System.out.println("Send Email");
        dao.insert(userDTO);
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public UserDTO get(String s) {
        return null;
    }

    @Override
    public List<UserDTO> get() {
        return null;
    }
}
