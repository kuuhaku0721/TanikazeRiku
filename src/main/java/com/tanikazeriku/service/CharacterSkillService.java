package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.CharacterSkill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CharacterSkillService {
    /**
     * 读取全部数据
     * @return kakuya_character_skill表所有数据
     */
    List<CharacterSkill> selectAll();

    /**
     * 根据id获取对应skill
     * @param id 需求的id
     * @return 对应的skill
     */
    CharacterSkill getSkillById(Integer id);
}
