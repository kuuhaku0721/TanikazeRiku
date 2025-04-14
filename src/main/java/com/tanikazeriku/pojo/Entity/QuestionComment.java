package com.tanikazeriku.pojo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionComment implements Serializable {
    private Integer id;
    private Integer userid;
    private String comment;
    private Long createTime;
    private Integer questionid;
}
