package com.spring.message;

import com.spring.utility.exception.ProjectException;
import com.spring.utility.message.CodeMessage;
import com.spring.utility.message.CodeMessageAccessor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum FoCodeMessage implements CodeMessage {

    // @formatter:off
    // 시스템메시지
    MSG_000001_시스템_오류_입니다_,
    MSG_000002_등록된_사용자_정보를_찾을수_없습니다_,
    MSG_000003_암호화_오류입니다_,
    MSG_000004_정보가_잘못_입력되었습니다__확인_후_다시_시도해_주세요_,
    MSG_000005_접근_권한이_없습니다_,
    MSG_000006_등록중_오류가_발생하였습니다_,
    MSG_000007_수정중_오류가_발생하였습니다_,
    MSG_000008_삭제중_오류가_발생하였습니다_,
    MSG_100001_유효한_파라미터가_아닙니다_

    // 사용자메세지
    // END
    ;
    // @formatter:on

    private String type;
    private String code;
    private String hint;


    FoCodeMessage() {
        if (!name().matches(MESSAGE_PATTERN)) {
            throw new IllegalArgumentException("Not pattern: " + name());
        }

        Pattern pattern = Pattern.compile(MESSAGE_PATTERN);
        Matcher matcher = pattern.matcher(name());

        matcher.find();

        type = matcher.group(1);
        code = matcher.group(2);
        hint = matcher.group(3);
    }


    @Override
    public String getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return CodeMessageAccessor.getMessage(code);
    }


    @Override
    public String getMessage(Object... params) {
        return CodeMessageAccessor.getMessage(code, params);
    }


    @Override
    public ProjectException toException() {
        throw new ProjectException(this);
    }


    @Override
    public ProjectException toException(Object... params) {
        return new ProjectException(this, params);
    }


    @Override
    public ProjectException toException(Throwable cause) {
        return new ProjectException(this, cause);
    }


    @Override
    public ProjectException toException(Throwable cause, Object... params) {
        return new ProjectException(this, params, cause);
    }
}
