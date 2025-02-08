package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.Item;

import java.util.List;

public interface ItemService {
    /**
     * 读取全部数据
     * @return kakuya_item表所有数据
     */
    List<Item> selectAll();
}
