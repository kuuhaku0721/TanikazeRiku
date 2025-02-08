package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.KakuyaItemMapper;
import com.tanikazeriku.pojo.Entity.Item;
import com.tanikazeriku.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private KakuyaItemMapper itemMapper;

    @Override
    public List<Item> selectAll() {
        return itemMapper.selectAll();
    }
}
