package com.spring.utility.mvc;


import com.spring.utility.exception.ProjectException;
import com.spring.utility.message.CodeMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class JSONResponse {

    private boolean success;
    private Object data;
    private String message;
    private String code;


    public static JSONResponse success(CodeMessage codeMessage) {
        return JSONResponse.of(Boolean.TRUE, null, codeMessage != null ? codeMessage.getMessage() : null, codeMessage.getCode());
    }


    public static JSONResponse success(CodeMessage codeMessage, Object... params) {
        return JSONResponse.of(Boolean.TRUE, null, codeMessage != null ? codeMessage.getMessage(params) : null, codeMessage.getCode());
    }


    public static JSONResponse success(Object data) {
        return JSONResponse.of(Boolean.TRUE, data, null, null);
    }


    public static JSONResponse failure(CodeMessage codeMessage) {
        return JSONResponse.of(Boolean.FALSE, null, codeMessage != null ? codeMessage.getMessage() : null, codeMessage.getCode());
    }


    public static JSONResponse failure(CodeMessage codeMessage, Object... params) {
        return JSONResponse.of(Boolean.FALSE, null, codeMessage != null ? codeMessage.getMessage(params) : null, codeMessage.getCode());
    }


    public static JSONResponse failure(Exception e) {
        if (e instanceof ProjectException) {
            return JSONResponse.failure(((ProjectException) e).getCodeMessage(), ((ProjectException) e).getParams());
        }
        return JSONResponse.of(Boolean.FALSE, null, e.getMessage(), null);
    }
}
