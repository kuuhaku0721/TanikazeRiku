package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.KakuyaUserMapper;
import com.tanikazeriku.pojo.Entity.User;
import com.tanikazeriku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private KakuyaUserMapper userMapper;

    @Override
    public User getAllUsers() {
        User user = userMapper.selectAll();
        return user;
    }
}
