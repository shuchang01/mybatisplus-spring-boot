package com.baomidou.springboot.exception;

/**
 * 自定义 tip 异常
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code;
    private String msg;
    private Object data;

    public BaseException() {
        super();
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(Throwable e) {
        super(e);
    }

    public BaseException(String msg, Throwable e) {
        super(msg, e);
    }

    public BaseException(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
