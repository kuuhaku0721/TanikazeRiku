package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.Dungeon;
import com.tanikazeriku.pojo.Entity.ImageWrapper;

import java.util.List;

public interface DungeonService {
    /**
     * 获取全部数据
     * @return kakuya_dungeon表所有数据
     */
    List<Dungeon> selectAll();

    /**
     * 提取所有图片
     * @return 图片集合
     */
    List<ImageWrapper> getAllImages();
}
