package com.tanikazeriku.mapper;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudyQuestionMapper {
    @Select("select * from study_question where category = #{category} and year = #{year};")
    List<Question> selectByCategoryAndYear(Integer category, Integer year);

    @Select("select image from study_question where id=#{id};")
    ImageWrapper getImageById(Integer id);

    @Select("select * from study_question where title like #{keyword} limit 1;")
    Question selectQuestionByKeyword(String keyword);
}
