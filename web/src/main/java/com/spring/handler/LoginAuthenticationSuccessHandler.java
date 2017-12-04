package com.spring.handler;

import com.spring.domain.member.Member;
import com.spring.security.domain.UserPrincipal;
import com.spring.utility.cipher.AesCipherUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class LoginAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public static final String SAVE_ID_PARAMETER_KEY = "idSave";


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        log.debug("login success handler: {}", authentication.getPrincipal());

        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        Member member = (Member) principal.getObject();

        // 쿠키 정보 저장
        if (Arrays.asList("on", "yes", "1").contains(request.getParameter(SAVE_ID_PARAMETER_KEY))) {
            Cookie cookie = new Cookie(SAVE_ID_PARAMETER_KEY, AesCipherUtils.encryptBase64(member.getMbrId()));
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie(SAVE_ID_PARAMETER_KEY, null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}