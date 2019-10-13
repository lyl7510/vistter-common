package com.base.vistter.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pager implements Serializable {

    //当前页
    private long pagerNumber = 1;

    //总条数
    private long total = 0;

    //每页条数
    private long pageSize = 20;

    //记录列表
    private List<Map> result = new ArrayList<>();

    public long getPagerNumber() {
        return pagerNumber;
    }

    public void setPagerNumber(long pagerNumber) {
        this.pagerNumber = pagerNumber;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public List<Map> getResult() {
        return result;
    }

    public void setResult(List<Map> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Pager{" +  "pagerNumber=" + pagerNumber + ", total=" + total + ", pageSize=" + pageSize + '}';
    }

}
