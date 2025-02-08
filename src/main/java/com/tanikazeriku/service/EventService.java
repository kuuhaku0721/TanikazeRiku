package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.Event;

import java.util.List;

public interface EventService {
    /**
     * 读取全部数据
     * @return kakuya_event_easy表所有数据
     */
    List<Event> selectAllEasy();

    /**
     * 读取全部数据
     * @return kakuya_event_normal表所有数据
     */
    List<Event> selectAllNormal();

    /**
     * 读取全部数据
     * @return kakuya_event_difficult表所有数据
     */
    List<Event> selectAllDifficult();
}
