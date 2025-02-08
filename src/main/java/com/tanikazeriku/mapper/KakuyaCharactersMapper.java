package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Characters;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaCharactersMapper {
    @Select("select * from kakuya_characters;")
    List<Characters> selectAll();
}
