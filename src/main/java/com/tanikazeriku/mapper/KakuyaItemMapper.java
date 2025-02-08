package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaItemMapper {
    @Select("select * from kakuya_item;")
    List<Item> selectAll();
}
