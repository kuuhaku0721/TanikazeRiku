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
public class KakuyaCharacterDTO implements Serializable {
    private Integer id;
    private String name;
    private Integer hp;
    private Integer mp;
    private Integer skillId;
    private Integer destroy;
    private Integer growth;
    private Integer precision;
    private Integer sustain;
    private Integer distance;
    private Integer speed;
}
