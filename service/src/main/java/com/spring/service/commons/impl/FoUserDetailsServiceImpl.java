package com.spring.service.commons.impl;

import com.spring.domain.member.Member;
import com.spring.mapper.member.MemberMapper;
import com.spring.security.domain.UserPrincipal;
import com.spring.utility.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Objects;

@Slf4j
public class FoUserDetailsServiceImpl implements UserDetailsService {

    private static final List<GrantedAuthority> USER_DEFAULT_AUTHORITIES = AuthorityUtils.createAuthorityList("ROLE_USER");

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("username: {}", username);

        Member member = memberMapper.getByMbrId(username);
        if (Objects.isNull(member)) {
            throw new UsernameNotFoundException("User not found.");
        }

        // @formatter:off
        return UserPrincipal.builder()
                .username(member.getMbrId())
                .password(member.getMbrPwd())
                .accountNonExpired(true)
                .accountNonLocked(!CommonUtils.ifBlank(member.getAcntLockYn(), true))
                .credentialsNonExpired(true)
                .enabled(CommonUtils.ifBlank(member.getAcntUseYn(), true))
                .object(member)
                .authorities(USER_DEFAULT_AUTHORITIES)
                .build();
        // @formatter:on
        // @formatter:on
    }
}