package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaUserMapper {
    @Select("select * from kakuya_users;")
    List<User> selectAll();


    ImageWrapper getIconById(Integer id);
}
