package com.tanikazeriku.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DuelModel implements Serializable {
    private Integer id;
    private String name;
    private Integer level;
    private String easyEvent;
    private String normalEvent;
    private String difficultEvent;
    private String itemArray;
}
