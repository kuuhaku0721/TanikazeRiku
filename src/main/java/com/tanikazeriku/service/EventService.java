package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.Event;
import com.tanikazeriku.pojo.Entity.ImageWrapper;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 根据id获取对应事件信息
     * @param id 需求的id
     * @return id对应的事件信息
     */
    Event getEasyEventById(Integer id);
    Event getNormalEventById(Integer id);
    Event getDifficultEventById(Integer id);

    /**
     * 根据id获取图片
     * @param id 需求的id
     * @return 对应的image
     */
    ImageWrapper getEasyEventImageById(Integer id);
    ImageWrapper getNormalEventImageById(Integer id);
    ImageWrapper getDifficultEventImageById(Integer id);
}
