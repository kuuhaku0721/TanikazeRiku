package com.tanikazeriku.service;

import com.tanikazeriku.pojo.Entity.QuestionComment;

import java.util.List;

public interface CommentService {
    /**
     * 根据题目id获取对应的评论数据
     * @param id 题目id（表里叫userid
     * @return 对应的所有评论数据
     */
    List<QuestionComment> selectCommentById(Integer id);
}
