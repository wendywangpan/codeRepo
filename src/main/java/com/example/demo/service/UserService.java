package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findUser(String userid){
        return this.userMapper.getUserInfo(userid);
    }
    public List<User> findAllUser(){
        return this.userMapper.getAllUser();
    }
}
