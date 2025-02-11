package com.tanikazeriku.service.implement;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.mapper.KakuyaCharactersMapper;
import com.tanikazeriku.pojo.Entity.Characters;
import com.tanikazeriku.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private KakuyaCharactersMapper charactersMapper;

    @Override
    public List<Characters> selectAll() {
        return charactersMapper.selectAll();
    }

    @Override
    public List<ImageWrapper> getAllImages() {
        return charactersMapper.getAllImages();
    }

    @Override
    public ImageWrapper getImageById(Integer id) {
        return charactersMapper.getImageById(id);
    }
}
