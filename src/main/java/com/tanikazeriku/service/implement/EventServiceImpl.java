package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.KakuyaEventDifficultMapper;
import com.tanikazeriku.mapper.KakuyaEventEasyMapper;
import com.tanikazeriku.mapper.KakuyaEventNormalMapper;
import com.tanikazeriku.pojo.Entity.Event;
import com.tanikazeriku.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private KakuyaEventEasyMapper eventEasyMapper;
    @Autowired
    private KakuyaEventNormalMapper eventNormalMapper;
    @Autowired
    private KakuyaEventDifficultMapper eventDifficultMapper;

    @Override
    public List<Event> selectAllEasy() {
        return eventEasyMapper.selectAll();
    }

    @Override
    public List<Event> selectAllNormal() {
        return eventNormalMapper.selectAll();
    }

    @Override
    public List<Event> selectAllDifficult() {
        return eventDifficultMapper.selectAll();
    }
}
