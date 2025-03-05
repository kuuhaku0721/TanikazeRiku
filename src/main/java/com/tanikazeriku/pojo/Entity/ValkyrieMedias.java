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
public class ValkyrieMedias implements Serializable {
    private Integer id;
    private String name;
    private String fileName;
    private String imageUri;
    private String descriptionShort;
    private String descriptionComplete;
}
