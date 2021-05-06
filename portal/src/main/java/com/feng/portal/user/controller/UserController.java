package com.feng.portal.user.controller;

import com.feng.portal.user.pojo.domain.User;
import com.feng.portal.user.pojo.resp.UserResp;
import com.feng.portal.user.service.UserService;
import com.feng.portal.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Objects;

/**
 * @program: portal
 * @description: TODO
 * @author: feng
 * @create: 2020-12-16 21:21
 * @version: 1.0
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @CrossOrigin
    @GetMapping("/test")
    public String test() {
        return "hello world!";
    }

    /**
     * 获取用户信息
     */
    @CrossOrigin
    @GetMapping("/users")
    public List<UserResp> getUsers() {
        return userService.getAllUser();
    }

    /**
     * 编辑用户
     */
    @CrossOrigin
    @PutMapping("/user")
    public void editUser(@RequestBody User user) {
        userService.editUser(user);
    }

    /**
     * Login
     */
    @CrossOrigin
    @PostMapping("/api/login")
    @ResponseBody
    public Result login(@RequestBody User user) {
        String username = user.getUsername();
        // 防止html转义
        username = HtmlUtils.htmlEscape(username);
        User userToLogin = userService.get(username, user.getPassword());
        if (null == userToLogin){
            String message = "账号密码错误";
            System.out.println("password error");
            return new Result(400);
        } else {
            System.out.println("登录成功");
            return new Result(200);
        }

    }
}