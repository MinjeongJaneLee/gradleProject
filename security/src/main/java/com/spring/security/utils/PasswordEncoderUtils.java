package com.spring.security.utils;


import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.ContextLoader;

import java.util.Objects;


@UtilityClass
@Slf4j
public class PasswordEncoderUtils {

    public String encode(String str) {
        PasswordEncoder passwordEncoder = ContextLoader.getCurrentWebApplicationContext().getBean(PasswordEncoder.class);

        log.debug("current passwordEncoder: {}", passwordEncoder);
        if (Objects.isNull(passwordEncoder)) {
            return null;
        }
        return passwordEncoder.encode(str);
    }
}
