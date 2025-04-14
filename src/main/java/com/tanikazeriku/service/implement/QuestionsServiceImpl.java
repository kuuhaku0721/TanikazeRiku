package com.tanikazeriku.service.implement;

import com.tanikazeriku.mapper.StudyQuestionMapper;
import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.Question;
import com.tanikazeriku.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    private StudyQuestionMapper studyQuestionMapper;

    @Override
    public List<Question> selectQuestionByCategoryAndYear(Integer category, Integer year) {
        return studyQuestionMapper.selectByCategoryAndYear(category, year);
    }

    @Override
    public ImageWrapper getImageById(Integer id) {
        return studyQuestionMapper.getImageById(id);
    }

    @Override
    public Question selectQuestionByKeyword(String keyword) {
        // TODO 追加一下try catch 防止服务器崩溃
        return studyQuestionMapper.selectQuestionByKeyword(keyword);
    }
}
