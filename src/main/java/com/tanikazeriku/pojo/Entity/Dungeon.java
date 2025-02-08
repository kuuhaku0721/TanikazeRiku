package com.tanikazeriku.pojo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dungeon implements Serializable {
    private Integer id;
    private String name;
    private byte[] image;
    private Integer level;
    private byte[] levelStar;
    private Integer easyEventCount;
    private Integer normalEventCount;
    private Integer difficultEventCount;
    private Integer itemCardCount;
}
