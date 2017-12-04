package com.spring.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

    private static final long serialVersionUID = 1427944587529615275L;

    private String mbrId;
    private String mbrPwd;
    private String mbrTypeCode;
    private String mbrNm;
    private String birth;
    private String tel;
    private String email;
    private String mbrMemo;
    private Boolean acntUseYn;
    private String acntReason;
    private Boolean smsRecpYn;
    private Boolean emailRecpYn;
    private String favCategory;
    private int loginErrorCnt;
    private Boolean acntLockYn;
    private String accntHolder;
    private String refundBank;
    private String refundAccnt;
    private Date regDate;
    private Date mdfDate;
}
