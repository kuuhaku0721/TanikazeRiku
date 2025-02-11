package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.Item;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemService {
    /**
     * 读取全部数据
     * @return kakuya_item表所有数据
     */
    List<Item> selectAll();

    /**
     * 根据id获取对应item数据
     * @param id 需求的id
     * @return 对应的item
     */
    Item getItemById(Integer id);

    /**
     * 根据id获取对应的图片
     * @param id 需求的id
     * @return 对应的image
     */
    ImageWrapper getItemImageById(Integer id);
}
