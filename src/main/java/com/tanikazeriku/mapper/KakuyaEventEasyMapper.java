package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaEventEasyMapper {
    @Select("select * from kakuya_event_easy;")
    List<Event> selectAll();
}
