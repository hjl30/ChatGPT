package com.kfm.mapper;

import com.kfm.entity.ChatEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {
    int insert(ChatEntity chat);
}
