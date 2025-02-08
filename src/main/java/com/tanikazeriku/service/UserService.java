package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();
}
