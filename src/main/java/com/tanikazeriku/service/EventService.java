package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.Event;

import java.util.List;

public interface EventService {
    List<Event> selectAllEasy();
    List<Event> selectAllNormal();
    List<Event> selectAllDifficult();
}
