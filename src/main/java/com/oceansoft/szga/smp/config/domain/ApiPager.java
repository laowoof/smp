package com.oceansoft.szga.smp.config.domain;

import java.util.List;

/**
 * 工具类
 * 2018-8-16 刘柱 增加方法注释，类注释，行内注释
 * @author ganlu
 * @create 2017-02-10 09:03
 * @email ganlu@gmail.com
 */
public class ApiPager<T> {


    /**
     * 客户端分页大小
     */
    public static final int API_PAGE_SIZE = 10;

    private int pageIndex;
    private int totalPage;
    private int pageSize;
    private long totalRow;
    private List<T> list;

    public ApiPager() {
        super();
    }

    public ApiPager(long totalRow, List<T> list, int pageIndex) {
        this(API_PAGE_SIZE, pageIndex, 0 > totalRow ? 0 : totalRow, list);
    }

    public ApiPager(int pageSize, int pageIndex, long totalRow, List<T> list) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.totalRow = 0 > totalRow ? 0 : totalRow;
        this.totalPage = (int) (totalRow % pageSize == 0 ? totalRow / pageSize : totalRow / pageSize + 1);
        this.list = list;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isHasNext() {
        return pageIndex < totalPage;
    }

    public long getTotalRow() {
        return totalRow;
    }
}
