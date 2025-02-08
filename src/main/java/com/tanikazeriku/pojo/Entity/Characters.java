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
public class Characters implements Serializable {
    private Integer id;
    private String name;
    private byte[] image;
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