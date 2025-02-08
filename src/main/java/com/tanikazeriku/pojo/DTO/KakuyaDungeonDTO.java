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
public class KakuyaDungeonDTO implements Serializable {
    private Integer id;
    private String name;
    private Integer level;
    private Integer easyEventCount;
    private Integer normalEventCount;
    private Integer difficultEventCount;
    private Integer itemCardCount;
}
