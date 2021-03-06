package com.wuzhaojun.controller;

import com.wuzhaojun.entity.UserEntity;
import com.wuzhaojun.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author EternalPain
 * @description:
 * @date 2021/3/19 11:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @PostMapping("/insertUser")
    public void insertUser(@RequestBody UserEntity userEntity){
        userService.insertUser(userEntity);
    }

    @GetMapping("/findUser")
    public List<UserEntity> findUser(){
        List<UserEntity> user = userService.findUser();
        return user;
    }

    @PostMapping("/updateUser")
    public void updateUser(@RequestBody UserEntity userEntity){
        userService.updateUser(userEntity);
    }

    /**
     * 登录
     * @param userEntity
     * @param session
     * @return
     */
    @PostMapping("/login")
    public Boolean login(@RequestBody UserEntity userEntity, HttpSession session){
        Boolean login = userService.login(userEntity,session);
        return login;
    }

    @GetMapping("/signOut")
    public Boolean signOut(HttpSession session){
        Boolean aBoolean = userService.signOut(session);
        return aBoolean;
    }

    /**
     * 注册
     * @param userEntity
     */
    @PostMapping("/register")
    public Boolean register(@RequestBody UserEntity userEntity){
        boolean register = userService.register(userEntity);
        return register;
    }



}
