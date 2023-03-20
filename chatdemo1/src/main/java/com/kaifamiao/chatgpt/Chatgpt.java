package com.kaifamiao.chatgpt;


import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.ChatChoice;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;

public class Chatgpt {
    public static void main(String[] args){
        //创建代理
        Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",7890));
        //打开链接
        OpenAiClient openAiClient =  OpenAiClient.builder()
                .apiKey("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")
                .connectTimeout(300)
                .proxy(proxy)
                .build();
        //chatgpt-3.5-turbo模型
        Message message = Message.builder()
                .role(Message.Role.USER)
                .content("歌曲sugar的歌词")
                .build();
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .messages(Arrays.asList(message))
                .build();
        //发送请求并接受响应结果
        ChatCompletionResponse chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);
        List<ChatChoice> choices = chatCompletionResponse.getChoices();
        String content = choices.get(0).getMessage().getContent();
        System.out.println(content);
    }
}
