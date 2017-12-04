package com.spring.domain.commons;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Code implements Serializable {

    private static final long serialVersionUID = -5272771734209368962L;

    private String code;
    private String codeGroup;
    private String codeNm;
    private String codeDesc;
    private String groupDesc;
    private Boolean publicYn;
    private Date regDate;
}
