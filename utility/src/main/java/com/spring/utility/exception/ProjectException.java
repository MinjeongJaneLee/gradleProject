package com.spring.utility.exception;


import com.spring.utility.message.CodeMessage;


public class ProjectException extends RuntimeException {

    private static final long serialVersionUID = 8694990730819301011L;

    private CodeMessage codeMessage;
    private Object[] params;


    public ProjectException(CodeMessage codeMessage) {
        this(codeMessage, (Throwable) null);
    }


    public ProjectException(CodeMessage codeMessage, Throwable cause) {
        this(codeMessage, null, cause);
    }


    public ProjectException(CodeMessage codeMessage, Object[] params) {
        this(codeMessage, params, null);
    }


    public ProjectException(CodeMessage codeMessage, Object[] params, Throwable cause) {
        super(cause);
        this.codeMessage = codeMessage;
        this.params = params;
    }


    public CodeMessage getCodeMessage() {
        return codeMessage;
    }


    public Object[] getParams() {
        return params;
    }


    @Override
    public String getMessage() {
        return codeMessage.getMessage(params);
    }
}
