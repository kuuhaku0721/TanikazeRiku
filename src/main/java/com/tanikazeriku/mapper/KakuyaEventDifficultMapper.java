package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaEventDifficultMapper {
    @Select("select * from kakuya_event_difficult;")
    List<Event> selectAll();
}
