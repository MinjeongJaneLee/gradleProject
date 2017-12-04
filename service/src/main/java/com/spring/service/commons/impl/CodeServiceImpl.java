package com.spring.service.commons.impl;

import com.spring.domain.commons.Code;
import com.spring.mapper.commons.CodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("codeService")
public class CodeServiceImpl {

    @Autowired
    private CodeMapper codeMapper;


    public List<Code> listBy(String codeGroup, String... opts) {
        return codeMapper.listByCodeGroup(codeGroup);
    }
}
