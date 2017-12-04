package com.spring.mapper.commons;

import com.spring.domain.commons.Code;

import java.util.List;

public interface CodeMapper {

    List<Code> listByCodeGroup(String codeGroup);
}
