package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Dungeon;
import com.tanikazeriku.pojo.Entity.ImageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaDungeonMapper {
    @Select("select * from kakuya_dungeon;")
    List<Dungeon> selectAll();

    /**
     * 提取所有图片
     * @return 图片集合
     */
    List<ImageWrapper> getAllImages();

    /**
     * 根据id获取图片
     * @param id dungeon id
     * @return id--image
     */
    @Select("select image from kakuya_dungeon where id=#{id};")
    ImageWrapper getImageById(Integer id);

    /**
     * 提取所有同一 level 的dungeon
     * @param level dungeon等级
     * @return 符合条件的所有dungeon
     */
    @Select("select * from kakuya_dungeon where level=#{level};")
    List<Dungeon> selectDungeonByLevel(int level);

    /**
     * 根据id获取图片
     * @param id dungeon id
     * @return id--image
     */
    @Select("select * from kakuya_dungeon where id=#{id};")
    Dungeon getLevelImageById(Integer id);
}
