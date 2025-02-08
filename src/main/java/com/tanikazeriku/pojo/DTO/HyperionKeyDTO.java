package com.tanikazeriku.pojo.DTO;

import java.io.Serializable;

public class HyperionKeyDTO implements Serializable {
    private String key = "qwertyuiopasdfghjklzxcvbnm";

    public String getKey() {
        return key;
    }

    // 如果用了@Data 就不需要重写，@Data下自带了
    @Override
    public String toString() {
        return "HyperionKeyDTO{" +
                "key='" + key + '\'' +
                '}';
    }
}
