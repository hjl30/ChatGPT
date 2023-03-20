package com.kfm.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatEntity implements Serializable {
    private Integer chatId;
    private String username;
    private String userKey;
    private String model;
    private String prompt;
    private String answer;
    private Boolean isEnd;
    private String requestIpAddress;
    private String responseJson;
    private String promptId;
    private String finishReason;
    private String requestUrl;
    private Data createTime;
    private static final long serialVersionUID=1L;
}
