package com.spring.utility.message;


import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Objects;


public class CodeMessageAccessor {

    private static MessageSourceAccessor messageSourceAccessor;


    public static void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        synchronized (CodeMessageAccessor.class) {
            CodeMessageAccessor.messageSourceAccessor = messageSourceAccessor;
        }
    }


    public static String getMessage(String code, Object... params) {
        if (Objects.isNull(messageSourceAccessor)) {
            throw new UnsupportedOperationException("Source accessor is null.");
        }
        return messageSourceAccessor.getMessage(code, params, LocaleContextHolder.getLocale());
    }
}
