package com.tanikazeriku.controller.Study;

import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.common.utils.GeneralUtils;
import com.tanikazeriku.pojo.DTO.StudyQuestionDTO;
import com.tanikazeriku.pojo.DTO.StudySearchDTO;
import com.tanikazeriku.pojo.Entity.Question;
import com.tanikazeriku.service.QuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("persona/study")
public class StudyPOSTController {

    @Autowired
    private QuestionsService questionsService;

    /**
     * 根据拿到的题目文字去搜索对应的题目
     * @param searchDTO 前端传的题目概要
     * @return 找到的第一个符合的题目信息
     */
    @PostMapping("/search")
    public Result getQuestionByText(@RequestBody StudySearchDTO searchDTO) {
        log.info("接收到的数据: {}", searchDTO);
        List<StudyQuestionDTO> questionsList = new ArrayList<>();
        List<String> searchPoint = Arrays.asList(searchDTO.getText().split(" "));
        for (String point: searchPoint) {
            Question question = questionsService.selectQuestionByKeyword("%" + point.replaceAll("^['\"]|['\"]$", "").trim() + "%");
            if(question != null) {
                StudyQuestionDTO dto = new StudyQuestionDTO();
                dto.setId(question.getId());
                dto.setCategory(question.getCategory());
                dto.setType(question.getType());
                dto.setYear(question.getYear());
                dto.setTitle(question.getTitle());
                if(question.getImgexist() == 1) {
                    dto.setImage("http://192.168.31.202:8080/gurei/study/image/" + question.getId());
                }
                dto.setAlternative(GeneralUtils.parseStringToKeyValuePair(question.getAlternative()));
                String[] selectedAnswer = question.getCorrect().split(";");
                List<String> answers = new ArrayList<>();
                answers.add("" + selectedAnswer[0].charAt(0));
                answers.addAll(Arrays.asList(selectedAnswer));
                dto.setCorrect(answers);
                questionsList.add(dto);
                break;
            }
        }
        if(questionsList.size() == 0) {
            StudyQuestionDTO question = new StudyQuestionDTO();
            question.setId(1);
            question.setCategory(1);
            question.setType(3);
            question.setYear(2015);
            question.setTitle("未查找到符合条件的题目");
            question.setImage("https://i1.hdslb.com/bfs/archive/05133458ba400998f8b87532c46f781059c5c8d7.jpg");
            question.setAlternative(GeneralUtils.parseStringToKeyValuePair("A:这是A答案;B:这是B答案;C:这是C答案;D:这是D答案;"));
            List<String> correctList = new ArrayList<>();
            correctList.add("A");
            question.setCorrect(correctList);
            questionsList.add(question);
        }

        return Result.success(questionsList);
    }
}
