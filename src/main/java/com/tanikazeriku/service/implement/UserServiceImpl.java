package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.KakuyaUserMapper;
import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.User;
import com.tanikazeriku.pojo.Entity.UserWrapper;
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

    @Override
    public ImageWrapper getIconById(Integer id) {
        return userMapper.getIconById(id);
    }

    @Override
    public UserWrapper getUserByUsername(String username) {
        // TODO 不做
        return null;
    }

    @Override
    public void registerUser(String username, String password) {
        // TODO 不做
    }
}
