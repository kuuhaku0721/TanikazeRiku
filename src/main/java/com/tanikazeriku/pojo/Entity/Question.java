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
public class Question implements Serializable {
    private Integer id;
    private Integer category;
    private Integer type;
    private Integer year;
    private String title;
    private String alternative;
    private String correct;
    private Integer imgexist;
}
