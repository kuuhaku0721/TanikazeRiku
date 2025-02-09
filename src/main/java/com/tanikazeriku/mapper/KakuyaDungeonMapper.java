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
}
