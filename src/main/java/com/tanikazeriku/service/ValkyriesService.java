package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.Valkyries;

import java.util.List;

public interface ValkyriesService {
    List<Valkyries> selectAll();

    Valkyries selectByName(String name);
}
