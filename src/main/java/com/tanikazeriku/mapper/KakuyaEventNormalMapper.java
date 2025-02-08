package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaEventNormalMapper {
    @Select("select * from kakuya_event_normal;")
    List<Event> selectAll();
}
