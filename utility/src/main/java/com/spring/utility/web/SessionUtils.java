package com.spring.utility.web;


import lombok.experimental.UtilityClass;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;


@UtilityClass
public final class SessionUtils {

    @SuppressWarnings("unchecked")
    public <T> T getAttribute(String name) {
        return (T) getSession().getAttribute(name);
    }


    public void setAttribute(String name, Object value) {
        getSession().setAttribute(name, value);
    }


    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        if (Objects.isNull(attributes)) {
            throw new IllegalStateException("HttpServletRequest not found.");
        }
        return attributes.getRequest();
    }


    public HttpSession getSession() {
        return getRequest().getSession(true);
    }
}
