package com.spring.utility.web;


import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Pagination implements Serializable {

    private static final long serialVersionUID = -5552803352001541456L;

    private int page = 1;
    private int max = 10;


    public <E> PageInfo<E> pagenate(ISelect select) {
        return new PageInfo<>(PageHelper.startPage(page, max).doSelectPage(select), 9);
    }
}
