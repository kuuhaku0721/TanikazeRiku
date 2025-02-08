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
public class KakuyaEventDTO implements Serializable {
    private Integer id;
    private Integer flag;
    private Boolean limit;
    private String type;
    private String name;
    private String description;
    private Integer affectDestroy;
    private Integer affectDistance;
    private Integer affectSpeed;
    private Integer affectSustain;
    private Integer affectPrecision;
    private Integer affectGrowth;
    private Integer affectHp;
    private Integer affectMp;
    private Integer affectItemId;
    private Integer durationCount;
    private Integer multiCount;
    private Float treasureRate;
    private Float gambleRate;
    private Integer determineId;
    private Integer itemboxGoldCount;
    private Integer uniqueDungeonId;
}
