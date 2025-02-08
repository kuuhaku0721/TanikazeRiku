package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.User;

import java.util.List;

public interface UserService {
    /**
     * 读取全部数据
     * @return kakuya_user表所有数据
     */
    List<User> selectAll();
}
