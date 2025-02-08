package com.tanikazeriku.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KakuyaCharacterSkillDTO implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private Integer cost;
    private String type;
    private Integer checkCount;
    private String skipType;
    private Integer stealCount;
    private Integer uniqueId;
    private Integer buffCount;
    private Integer buffEventId;
}
