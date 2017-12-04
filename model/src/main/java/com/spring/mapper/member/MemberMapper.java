package com.spring.mapper.member;

import com.spring.domain.member.Member;

public interface MemberMapper {

    Member getByMbrId(String mbrId);
}
