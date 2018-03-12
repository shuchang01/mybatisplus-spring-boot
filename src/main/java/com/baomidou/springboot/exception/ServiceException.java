package com.baomidou.springboot.exception;

/**
 * 自定义 业务层 异常
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code;
    private String msg;
    private Object data;

    public ServiceException() {
        super();
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(Throwable e) {
        super(e);
    }

    public ServiceException(String msg, Throwable e) {
        super(msg, e);
    }

    public ServiceException(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
