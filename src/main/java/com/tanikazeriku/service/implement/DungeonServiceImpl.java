package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.KakuyaDungeonMapper;
import com.tanikazeriku.pojo.Entity.Dungeon;
import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.service.DungeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DungeonServiceImpl implements DungeonService {
    @Autowired
    private KakuyaDungeonMapper dungeonMapper;

    @Override
    public List<Dungeon> selectAll() {
        return dungeonMapper.selectAll();
    }

    @Override
    public List<ImageWrapper> getAllImages() {
        return dungeonMapper.getAllImages();
    }
}
