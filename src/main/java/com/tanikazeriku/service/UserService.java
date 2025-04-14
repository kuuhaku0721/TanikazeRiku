package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.User;
import com.tanikazeriku.pojo.Entity.UserWrapper;

import java.util.List;

public interface UserService {
    /**
     * 读取全部数据
     * @return kakuya_user表所有数据
     */
    List<User> selectAll();

    /**
     * 根据用户id获取头像
     * @param id 用户id
     * @return 头像icon
     */
    ImageWrapper getIconById(Integer id);

    /**
     * 根据用户名找对应用户
     * @param username 用户名
     * @return 用户
     */
    UserWrapper getUserByUsername(String username);

    /**
     * 注册用户
     * @param username 用户名
     * @param password 密码
     */
    void registerUser(String username, String password);
}
