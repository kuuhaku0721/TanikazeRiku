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
public class Item implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private byte[] image;
    private Boolean buyable;
    private Integer cost;
    private String uniqueType;
    private String healType;
    private Integer healNum;
    private Integer buffDestroy;
    private Integer buffDistance;
    private Integer buffSpeed;
    private Integer buffSustain;
    private Integer buffPrecision;
    private Integer buffGrowth;
}
