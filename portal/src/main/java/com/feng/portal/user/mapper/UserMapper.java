package com.feng.portal.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.portal.user.pojo.domain.User;
import com.feng.portal.user.pojo.resp.UserResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT username, name, phone, email FROM `user` t;")
    List<UserResp> getAllUser();
}
