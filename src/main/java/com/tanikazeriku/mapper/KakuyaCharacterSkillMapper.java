package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.CharacterSkill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaCharacterSkillMapper {
    @Select("select * from kakuya_character_skill;")
    List<CharacterSkill> selectAll();

    /**
     * 根据id获取对应skill
     * @param id 需求的id
     * @return 对应的skill
     */
    @Select("select * from kakuya_character_skill where id = #{id};")
    CharacterSkill getSkillById(Integer id);
}
