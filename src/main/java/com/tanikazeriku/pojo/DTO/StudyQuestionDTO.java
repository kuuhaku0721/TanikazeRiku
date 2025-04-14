package com.tanikazeriku.pojo.DTO;

import com.tanikazeriku.common.utils.KVPair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyQuestionDTO implements Serializable {
    private Integer id;
    private Integer category;
    private Integer type;
    private Integer year;
    private String title;
    private String image;
    private List<KVPair> alternative;
    private List<String> correct;
}
