package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.Question;

import java.util.List;

public interface QuestionsService {
    /**
     * 根据category和year找出所有符合的题目
     * @param category 类别
     * @param year 年份
     * @return 题目列表
     */
    List<Question> selectQuestionByCategoryAndYear(Integer category, Integer year);

    /**
     * 根据id获取对应图片
     * @param id  id
     * @return id--image
     */
    ImageWrapper getImageById(Integer id);

    /**
     * 根据关键词通配查找符合条件的某一条记录
     * @param keyword 关键词
     * @return 通配查找到的记录
     */
    Question selectQuestionByKeyword(String keyword);
}
