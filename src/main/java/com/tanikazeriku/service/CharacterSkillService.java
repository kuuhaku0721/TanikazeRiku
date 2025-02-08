package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.CharacterSkill;

import java.util.List;

public interface CharacterSkillService {
    /**
     * 读取全部数据
     * @return kakuya_character_skill表所有数据
     */
    List<CharacterSkill> selectAll();
}
