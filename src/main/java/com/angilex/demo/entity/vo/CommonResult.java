package com.angilex.demo.entity.vo;

/**
 * 通用返回对象
 */
public class CommonResult<T> {

    // 状态码
    private long code;

    // 提示信息
    private String msg;

    // 数据封装
    private T data;

    public CommonResult(long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
