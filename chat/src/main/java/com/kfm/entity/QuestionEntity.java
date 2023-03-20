package com.kfm.entity;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@Component
public class QuestionEntity {
    @NotBlank(message = "问题不能为空")
    private String question;
    private boolean isContinue;
}
