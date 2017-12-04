package com.spring.security.utils;

import com.spring.security.domain.UserPrincipal;
import com.spring.utility.CommonUtils;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class AuthenticationUtils {


    /**
     * User info
     */
    public Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (CommonUtils.isBlank(context)) {
            return null;
        }

        return context.getAuthentication();
    }


    public UserPrincipal getUserPrincipal() {
        Authentication authentication = getAuthentication();
        if (CommonUtils.isBlank(authentication)) {
            return null;
        }

        if (!(authentication.getPrincipal() instanceof UserPrincipal)) {
            return null;
        }

        return (UserPrincipal) authentication.getPrincipal();
    }


    public String getUsername() {
        Authentication authentication = getAuthentication();
        if (CommonUtils.isBlank(authentication)) {
            return null;
        }

        if (authentication.getPrincipal() instanceof String) {
            return (String) authentication.getPrincipal();
        }

        if (authentication.getPrincipal() instanceof UserPrincipal) {
            return ((UserPrincipal) authentication.getPrincipal()).getUsername();
        }

        return null;
    }
}
