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
public class ValkyrieInfoModel implements Serializable {
    private String title;
    private String subTitle;
    private String imageUri;
    private String description;
}
