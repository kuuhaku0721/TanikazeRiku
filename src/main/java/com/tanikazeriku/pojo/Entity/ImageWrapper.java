package com.tanikazeriku.pojo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * image-->byte[] 包装类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageWrapper implements Serializable {
    private byte[] image;
}
