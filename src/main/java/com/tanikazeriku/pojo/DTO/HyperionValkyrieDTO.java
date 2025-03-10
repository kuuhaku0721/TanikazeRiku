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
public class HyperionValkyrieDTO implements Serializable {
    private String name;
    private String imageUri;
}
