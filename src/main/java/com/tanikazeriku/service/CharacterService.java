package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.Characters;

import java.util.List;

public interface CharacterService {
    List<Characters> selectAll();
}
