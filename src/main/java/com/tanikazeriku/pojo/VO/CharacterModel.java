package com.tanikazeriku.pojo.VO;

import com.tanikazeriku.pojo.DTO.KakuyaCharacterDTO;
import com.tanikazeriku.pojo.DTO.KakuyaCharacterSkillDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterModel implements Serializable {
    private KakuyaCharacterDTO characters;
    private KakuyaCharacterSkillDTO characterSkill;
}
