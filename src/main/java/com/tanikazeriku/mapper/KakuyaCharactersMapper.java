package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.Characters;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaCharactersMapper {
    @Select("select * from kakuya_characters;")
    List<Characters> selectAll();

    /**
     * 提取所有图片
     * @return 图片集合
     */
    List<ImageWrapper> getAllImages();

    /**
     * 根据id获取对应image
     * @param id 需求的id
     * @return 对应的image
     */
    @Select("select image from kakuya_characters where id = #{id};")
    ImageWrapper getImageById(Integer id);
}
