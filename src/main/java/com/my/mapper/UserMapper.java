package com.my.mapper;

import com.my.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository //把mapper接口注册为spring的bean，避免@autowired时爆红（无影响）
public interface UserMapper {
    public List<User> queryUserList();
}
