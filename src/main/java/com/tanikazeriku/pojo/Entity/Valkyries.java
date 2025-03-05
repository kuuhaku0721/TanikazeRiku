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
public class Valkyries implements Serializable {
    private Integer id;
    private String name;
    private String title;
    private String nameId;
    private String imageUri;
    private String color;
    private String description;
    private Integer saintfreya;
    private Integer flamechasers;
    private Integer hyperion;
}
