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
public class KakuyaUserDTO implements Serializable {
    private Integer id;
    private String username;
    private Integer trophies;
    private String enisDungeon;
    private String zweiDungeon;
    private String dreiDungeon;
}
