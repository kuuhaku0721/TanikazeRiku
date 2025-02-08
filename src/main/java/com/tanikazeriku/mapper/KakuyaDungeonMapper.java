package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Dungeon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaDungeonMapper {
    @Select("select * from kakuya_dungeon;")
    List<Dungeon> selectAll();
}
