package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Event;
import com.tanikazeriku.pojo.Entity.ImageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KakuyaEventEasyMapper {
    @Select("select * from kakuya_event_easy;")
    List<Event> selectAll();

    /**
     * 根据id获取对应事件信息
     * @param id 需求的id
     * @return id对应的事件信息
     */
    @Select("select * from kakuya_event_easy where id = #{id};")
    Event getEventById(Integer id);

    /**
     * 根据id获取图片
     * @param id 需求的id
     * @return 对应的图片
     */
    @Select("select image from kakuya_event_easy where id = #{id};")
    ImageWrapper getImageById(Integer id);
}
