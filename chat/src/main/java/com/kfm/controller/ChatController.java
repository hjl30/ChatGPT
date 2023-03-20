package com.kfm.controller;

import com.kfm.entity.ChatEntity;
import com.kfm.entity.QuestionEntity;
import com.kfm.service.impl.ChatService;
import com.kfm.utils.AjaxResult;
import com.kfm.utils.OpenAiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/open-ai")
public class ChatController {
    @Resource
    private OpenAiUtils utils;
    @Autowired
    private ChatService chatService;
    @PostMapping("/ask")
    public AjaxResult chatGpt(@RequestBody QuestionEntity question, HttpServletRequest request) {
        String ip = "0:0:0:0:0:0:0:1".equals(request.getRemoteAddr()) ? "127.0.0.1" : request.getRemoteAddr();
        ChatEntity chat = utils.getChat(question, ip);

        int i = chatService.insert(chat);
        if (i>0) {
            return AjaxResult.success(chat);
        } else {
            return AjaxResult.faile("失败！");
        }
    }

}

