package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.ValkyrieMedias;

import java.util.List;

public interface ValkyrieMediasService {
    List<ValkyrieMedias> selectAll();

    ValkyrieMedias selectByName(String name);
}
