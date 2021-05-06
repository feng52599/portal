package com.feng.portal.user.pojo.resp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: portal
 * @description: TODO
 * @author: feng
 * @create: 2020-12-16 22:01
 * @version: 1.0
 */
@Data
public class UserResp {
    private Integer id;

    private String username;

    private String name;

    private String phone;

    private String email;

}