package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.ValkyrieMedias;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HyperionValkyrieMediasMapper {
    @Select("select * from hyperion_medias;")
    List<ValkyrieMedias> selectAll();

    @Select("select * from hyperion_medias where name = #{name};")
    ValkyrieMedias selectByName(String name);
}
