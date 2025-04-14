package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.Item;
import com.tanikazeriku.pojo.Entity.QuestionComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudyCommentMapper {
    @Select("select * from study_comment where questionid = #{id};")
    List<QuestionComment> selectCommentById(Integer id);
}
