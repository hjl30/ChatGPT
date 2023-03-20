package com.kfm.utils;


import com.alibaba.fastjson.JSON;
import com.kfm.config.ChatConfig;
import com.kfm.entity.ChatEntity;
import com.kfm.entity.QuestionEntity;
import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.ChatChoice;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;

@Component
public class OpenAiUtils {
    //    @Resource
//    private QuestionEntity question;
    @Resource
    private ChatConfig config;
    private ChatCompletionResponse chatCompletionResponse;
    public String getContent(QuestionEntity question){
        //创建代理
        Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress(config.getHostName(),config.getPort()));
        //打开连接
        OpenAiClient openAiClient= OpenAiClient.builder().apiKey(config.getApiKey())
                .connectTimeout(config.getConnectTimeout())
                .proxy(proxy)
                .build();
        //chatgpt-3.5-turbo模型
        Message message=Message.builder()
                .role(Message.Role.USER)
                .content(question.getQuestion())
                .build();
        ChatCompletion chatCompletion=ChatCompletion.builder()
                .messages(Arrays.asList(message))
                .build();
        //发送请求并接受响应结果
        chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);
        List<ChatChoice> choices=chatCompletionResponse.getChoices();
        String content = choices.get(0).getMessage().getContent();
        System.out.println(content);
        return content;
    }
    public ChatEntity getChat(QuestionEntity question,String ip){
        ChatEntity chat=new ChatEntity();
        chat.setUsername("HJL+King");
        chat.setAnswer(getContent(question));
        chat.setUserKey(chatCompletionResponse.getId());
        chat.setModel(chatCompletionResponse.getModel());
        chat.setPrompt(question.getQuestion());
        chat.setIsEnd(true);
        chat.setRequestIpAddress(ip);
        chat.setResponseJson(JSON.toJSONString(chatCompletionResponse));
        chat.setPromptId(chatCompletionResponse.getId());
        chat.setFinishReason("stop");
        chat.setRequestUrl(null);
        return chat;
    }
}