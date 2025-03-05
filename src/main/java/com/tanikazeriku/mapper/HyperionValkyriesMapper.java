package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Valkyries;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HyperionValkyriesMapper {
    @Select("select * from hyperion_characters;")
    List<Valkyries> selectAll();

    @Select("select * from hyperion_characters where name = #{name};")
    Valkyries selectByName(String name);
}
