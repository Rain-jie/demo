package com.deal.demo.utils.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Title: CustomPageInfo.java <br>
 * @Package com.jxp.utils.page <br>
 * @Description: (分页返回对象) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 2019/11/20 19:41 <br>
 */
public class CustomPageInfo<T> implements Serializable{

    //总记录数(一共有多少内容)
    private long total;
    //当前页数
    private int pageNum;
    //当前页显示数量
    private int pageSize;
    //总页数
    private int pages;
    //当前页面一共有几条
    private int size;
    //是否有下一页
    private boolean hasNextPage;
    //是否有前一页
    private boolean hasPreviousPage;
    //是否是第一页
    private boolean isFirstPage;
    //是否是最后一页
    private boolean isLastPage;
    //所有导航页号
    private int[] navigatepageNums;
    //显示内容
    private List<T> showList;
    //保存一些额外的数据
    private Map<Object, Object> otherData;

    private static final long serialVersionUID = 1L;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public List<T> getShowList() {
        return showList;
    }

    public void setShowList(List<T> showList) {
        this.showList = showList;
    }

    public Map<Object, Object> getOtherData() {
        return otherData;
    }

    public void setOtherData(Map<Object, Object> otherData) {
        this.otherData = otherData;
    }

    public void addOtherData(Object key, Object value){
        if (this.otherData==null){
            this.otherData = new HashMap<>(4);
        }
        this.otherData.put(key, value);
    }
}
