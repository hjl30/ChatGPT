package com.kfm.service.impl;

import com.kfm.entity.ChatEntity;
import com.kfm.mapper.ChatMapper;
import com.kfm.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChatService implements IChatService {
    @Autowired
    private ChatMapper chatMapper;

    @Override
    public int insert(ChatEntity chat) {
        return chatMapper.insert(chat);
    }
}
