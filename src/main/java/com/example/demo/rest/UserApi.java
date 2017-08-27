package com.example.demo.rest;

import com.example.demo.domain.MyPageInfo;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserApi {
    @Autowired
    private UserService userService;

    @GetMapping(value = "findUser")
    public User findUser(String userid){
        return this.userService.findUser(userid);
    }

    @GetMapping(value = "findAllUser")
    public PageInfo<User> findAllUser(@RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum,
                                      @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = this.userService.findAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        MyPageInfo<User> myPageInfo = new MyPageInfo();
        myPageInfo.setList(pageInfo.getList());
        System.out.println(myPageInfo);
        return pageInfo;
    }
}
