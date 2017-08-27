package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where userid = #{userid}")
    public User getUserInfo(String userid);
    @Select("select * from user")
    public List<User> getAllUser();
}
