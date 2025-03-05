package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.HyperionValkyrieMediasMapper;
import com.tanikazeriku.pojo.Entity.ValkyrieMedias;
import com.tanikazeriku.service.ValkyrieMediasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValkyrieMediasServiceImpl implements ValkyrieMediasService {

    @Autowired
    private HyperionValkyrieMediasMapper hyperionValkyrieMediasMapper;


    @Override
    public List<ValkyrieMedias> selectAll() {
        return hyperionValkyrieMediasMapper.selectAll();
    }

    @Override
    public ValkyrieMedias selectByName(String name) {
        return hyperionValkyrieMediasMapper.selectByName(name);
    }
}
