package com.qf.with_my_car.utils;

public class PageBean<T> {
    private int page;//当前页
    private int rowsPerPage = 5;//每页显示数据
    private int rowsNum;//总行数
    private int pageNum;//总页数
    private int pageIndex;//起始行号
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getRowsNum() {
        return rowsNum;
    }

    public void setRowsNum(int rowsNum) {
        this.rowsNum = rowsNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
    //a
    @Override
    public String toString() {
        return "PageBean{" +
                "page=" + page +
                ", rowsPerPage=" + rowsPerPage +
                ", rowsNum=" + rowsNum +
                ", pageNum=" + pageNum +
                ", pageIndex=" + pageIndex +
                '}';
    }
}
