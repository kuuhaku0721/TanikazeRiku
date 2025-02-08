package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KakuyaUserMapper {
    @Select("select * from kakuya_users")
    User selectAll();
}
