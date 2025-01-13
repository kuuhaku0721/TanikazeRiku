package com.tanikazeriku.tanikazeriku.pojo.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class HyperionUserDTO implements Serializable {
    private String username;
    private String password;
}
