package com.ww.loginmvp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ww.loginmvp.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    // 演示：手写复杂查询，JPA 不方便时再用
    @Select("SELECT * FROM t_user WHERE nick_name LIKE CONCAT('%', #{keyword}, '%')")
    List<User> searchByNick(String keyword);
}