package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.Dungeon;
import com.tanikazeriku.pojo.Entity.ImageWrapper;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 根据id获取对应图片
     * @param id dungeon id
     * @return id--image
     */
    ImageWrapper getImageById(Integer id);

    /**
     * 提取所有同一 level 的dungeon
     * @param level dungeon等级
     * @return 符合条件的所有dungeon
     */
    List<Dungeon> selectDungeonByLevel(int level);

    /**
     * 根据id获取图片
     * @param id dungeon id
     * @return id--image
     */
    Dungeon getLevelImageById(Integer id);
}
