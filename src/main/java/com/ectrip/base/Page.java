package com.ectrip.base;

/**
 * Created by huangxinguang on 2017/5/18.
 */
public class Page {

    private Integer pageNo;
    private Integer pageSize;

    public Page() {
        this.pageNo = 1;
        this.pageSize = 10;
    }

    public Page(Integer pageNo) {
        this.pageNo = pageNo;
        this.pageSize = 10;
    }

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
