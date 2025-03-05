package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.HyperionValkyriesMapper;
import com.tanikazeriku.pojo.Entity.Valkyries;
import com.tanikazeriku.service.ValkyriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValkyriesServiceImpl implements ValkyriesService {
    @Autowired
    private HyperionValkyriesMapper hyperionValkyriesMapper;


    @Override
    public List<Valkyries> selectAll() {
        return hyperionValkyriesMapper.selectAll();
    }

    @Override
    public Valkyries selectByName(String name) {
        return hyperionValkyriesMapper.selectByName(name);
    }
}
