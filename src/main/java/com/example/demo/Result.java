package com.example.demo;
import lombok.Data;

/**
 * 统一结果处理类
 *
 * @author 白豆五
 * @version 2023/04/21
 * @since JDK8
 */
@Data
public class Result<T> {
    private Integer code; //响应状态码
    private String msg;   //响应消息
    private T data;       //响应数据

    /**
     * 处理成功的返回结果
     *
     * @param data 数据
     * @param <T>
     * @return R<T>
     */
    public static <T> Result<T> success(T data, String msg) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    /**
     * 处理失败的返回结果
     *
     * @param msg 错误信息
     * @param <T>
     * @return R<T>
     */
    public static <T> Result<T> error(String msg) {
        Result<T> r = new Result<>();
        r.setCode(503);
        r.setMsg(msg);
        return r;
    }
}
