package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.CharacterSkill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaCharacterSkillMapper {
    @Select("select * from kakuya_character_skill;")
    List<CharacterSkill> selectAll();
}
