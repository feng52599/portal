package com.feng.portal.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.portal.user.pojo.domain.User;
import com.feng.portal.user.pojo.resp.UserResp;

import java.util.List;

/**
 * @program: portal
 * @description: TODO
 * @author: feng
 * @create: 2020-12-16 21:31
 * @version: 1.0
 */
public interface UserService extends IService<User> {
    List<UserResp> getAllUser();

    void editUser(User user);

    User get(String username, String password);
}