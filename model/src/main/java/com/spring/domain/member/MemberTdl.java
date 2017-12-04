package com.spring.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberTdl {

    private Long bizmoney;
    private Long point;
    private Integer useAmt;
    private String useAmtStatusYn;

}
