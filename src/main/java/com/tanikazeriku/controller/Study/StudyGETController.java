package com.tanikazeriku.controller.Study;

import com.tanikazeriku.common.request.Result;
import com.tanikazeriku.common.utils.GeneralUtils;
import com.tanikazeriku.pojo.Entity.ImageWrapper;
import com.tanikazeriku.pojo.Entity.Question;
import com.tanikazeriku.pojo.Entity.QuestionComment;
import com.tanikazeriku.pojo.DTO.StudyQuestionDTO;
import com.tanikazeriku.service.CommentService;
import com.tanikazeriku.service.QuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("gurei/study")
public class StudyGETController {

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private CommentService commentService;

    /**
     * 根据类型和年份获取对应的题目列表
     * @param category 类型
     * @param year 年份
     * @return 题目列表
     */
    @GetMapping("/exercise/{category}/{year}")
    public Result getCategoryExercisesByYear(@PathVariable Integer category, @PathVariable Integer year) {
        List<Question> questions = questionsService.selectQuestionByCategoryAndYear(category, year);
        List<StudyQuestionDTO> questionsList = new ArrayList<>();
        for (int i = 1; i < questions.size(); i++) {
            Question question = questions.get(i);
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
        }

        return Result.success(questionsList);
    }

    /**
     * 根据题目id获取对应的comment
     * @param id 题目id
     * @return 该题目下的comment列表
     */
    @GetMapping("/comment/{id}")
    public Result getCommentById(@PathVariable Integer id) {
        List<QuestionComment> comments = commentService.selectCommentById(id);
        return Result.success(comments);
    }

    /**
     * 根据id获取图片
     * @param id dungeon的id
     * @return 对应的图片
     */
    @GetMapping(value = "image/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImageById(@PathVariable int id) {
        log.info("dungeon id: {}", id);
        ImageWrapper image = questionsService.getImageById(id);
        if (image != null) {
            return ResponseEntity.ok().body(image.getImage());
        }
        return ResponseEntity.notFound().build();
    }

}
