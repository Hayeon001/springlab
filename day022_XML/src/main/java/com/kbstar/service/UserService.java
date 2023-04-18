package com.kbstar.service;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;

import java.util.List;

public class UserService implements MyService<String, UserDTO> {
    MyDao<String, UserDTO> dao;

    //객체를 생성하지 않음.
    public UserService(MyDao dao){
        this.dao = dao;
    };

    public void register(UserDTO userDTO) {
        //sql문. db가 바뀔때 dao가 알아서해라
        dao.insert(userDTO);
        System.out.println("Send Mail");
    }

    public void remove(String s) {
        dao.delete(s);
    }

    public void modify(UserDTO userDTO) {
        dao.update(userDTO);
        System.out.println("Send Mail");
    }

    public UserDTO get(String s) {
        return dao.select(s);
    }

    public List<UserDTO> get() {
        return dao.select();
    }
}
