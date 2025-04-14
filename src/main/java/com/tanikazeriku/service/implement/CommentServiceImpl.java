package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.StudyCommentMapper;
import com.tanikazeriku.pojo.Entity.QuestionComment;
import com.tanikazeriku.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private StudyCommentMapper studyCommentMapper;
    @Override
    public List<QuestionComment> selectCommentById(Integer id) {
        return studyCommentMapper.selectCommentById(id);
    }
}
