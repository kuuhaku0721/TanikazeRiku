package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaItemMapper {
    @Select("select * from kakuya_item;")
    List<Item> selectAll();

    /**
     * 根据id获取对应item数据
     * @param id 需求的id
     * @return 对应的item
     */
    @Select("select * from kakuya_item where id = #{id};")
    Item getItemById(Integer id);

    /**
     * 根据id获取对应的图片
     * @param id 需求的id
     * @return 对应的image
     */
    @Select("select image from kakuya_item where id = #{id}; ")
    ImageWrapper getItemImageById(Integer id);
}
