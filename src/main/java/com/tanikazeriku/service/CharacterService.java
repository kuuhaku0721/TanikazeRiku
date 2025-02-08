package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.Characters;

import java.util.List;

public interface CharacterService {
    /**
     * 读取全部数据
     * @return kakuya_character表所有数据
     */
    List<Characters> selectAll();

    /**
     * 提取所有图片
     * @return 图片集合
     */
    List<ImageWrapper> getAllImages();
}
