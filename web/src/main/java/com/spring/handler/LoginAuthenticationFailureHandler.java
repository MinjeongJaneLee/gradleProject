package com.spring.handler;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public static final String AUTHENTICATION_USERNAME = "SPRING_SECURITY_LAST_USERNAME";

    private String usernameParameter;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        saveUsername(request);

        super.onAuthenticationFailure(request, response, exception);
    }


    protected final void saveUsername(HttpServletRequest request) {
        log.debug("Save username - {}: {}", usernameParameter, request.getParameter(usernameParameter));

        if (isUseForward()) {
            request.setAttribute(AUTHENTICATION_USERNAME, request.getParameter(usernameParameter));
        } else {
            request.getSession(true).setAttribute(AUTHENTICATION_USERNAME, request.getParameter(usernameParameter));
        }
    }
}