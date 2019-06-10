package com.edas.edascommon.model;

import com.github.pagehelper.PageSerializable;

import java.util.List;

public class PageList<T> extends PageSerializable {

    private static final long serialVersionUID = -4318162326895987772L;

    public PageList() {
        super();
    }

    public PageList(List<T> rows) {
        super(rows);
    }

    public PageList(List<T> rows,long total) {
        super(rows);
        super.setTotal(total);
    }
}
