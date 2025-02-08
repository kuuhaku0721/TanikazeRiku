package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.KakuyaCharacterSkillMapper;
import com.tanikazeriku.pojo.Entity.CharacterSkill;
import com.tanikazeriku.service.CharacterSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterSkillServiceImpl implements CharacterSkillService {
    @Autowired
    private KakuyaCharacterSkillMapper characterSkillMapper;

    @Override
    public List<CharacterSkill> selectAll() {
        return characterSkillMapper.selectAll();
    }
}
