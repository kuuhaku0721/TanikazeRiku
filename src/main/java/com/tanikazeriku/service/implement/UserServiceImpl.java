package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.KakuyaUserMapper;
import com.tanikazeriku.pojo.Entity.User;
import com.tanikazeriku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private KakuyaUserMapper userMapper;


    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
