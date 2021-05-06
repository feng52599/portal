package com.feng.portal.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.portal.user.mapper.UserMapper;
import com.feng.portal.user.pojo.domain.User;
import com.feng.portal.user.pojo.resp.UserResp;
import com.feng.portal.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: portal
 * @description: TODO
 * @author: feng
 * @create: 2020-12-16 21:31
 * @version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResp> getAllUser() {
        return userMapper.getAllUser();
    }


    // todo 做错了 不应该这个Resp去做 应该取出user
    @Override
    public void editUser(User user) {
        UserResp userByUserName = getUserByUserName(user.getUsername());
        if (!StringUtils.isEmpty(user.getEmail())) {
            userByUserName.setEmail(user.getEmail());
        }
        if (!StringUtils.isEmpty(user.getName())) {
            userByUserName.setName(user.getName());
        }
        if (!StringUtils.isEmpty(user.getUsername())) {
            userByUserName.setEmail(user.getUsername());
        }
        if (!StringUtils.isEmpty(user.getPhone())) {
            userByUserName.setPhone(user.getPhone());
        }

        this.updateById(user);
    }

    private UserResp getUserByUserName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username", username);
        User user = this.getOne(wrapper);
        UserResp userResp = new UserResp();
        BeanUtils.copyProperties(user, userResp);
        return userResp;
    }

    @Override
    public User get(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(username)) {
            wrapper.eq("username", username);
        }
        if (!StringUtils.isEmpty(password)) {
            wrapper.eq("password", password);
        }
        return userMapper.selectOne(wrapper);
    }
}