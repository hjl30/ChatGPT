package com.kfm.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AjaxResult {
    private static final int SUCCESS_CODE = 1;
    private static final int FAILE_CODE =0;
    //响应码
    private int code;
    //响应信息
    private String message;
    //响应数据
    private Object data;
    //响应时间
    private long timestamp;

    public static AjaxResult success(Object data) {
        return new AjaxResult(SUCCESS_CODE,"成功！",data,System.currentTimeMillis());
    }
    public static AjaxResult faile(String message) {
        return new AjaxResult(FAILE_CODE,message,null,System.currentTimeMillis());
    }
}
