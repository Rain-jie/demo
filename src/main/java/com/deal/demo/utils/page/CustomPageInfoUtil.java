package com.deal.demo.utils.page;


import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Title: CustomPageInfoUtil.java <br>
 * @Package com.jxp.utils.page <br>
 * @Description: (自定义pageInfo相关内容) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 2019/11/20 19:41 <br>
 */
public class CustomPageInfoUtil<T> {

    /**
     * @throws
     * @author: 路逸冰(Allen) <br>
     * @date: 2019/11/20 19:41<br>
     * @modify 修改人 <br>
     * @modifyDate: 修改时间 <br>
     * @Title: getPageInfo <br>
     * @Description: (获取pageInfo返回的内容) <br>
     * @parma: [list] <br>
     * @return: customPageInfo<br>
     */
    public static <T> CustomPageInfo<T> getPageInfo(List<T> list){
        PageInfo<T> pageInfo = new PageInfo<>(list);
        CustomPageInfo<T> customPageInfo = new CustomPageInfo<>();
        customPageInfo.setTotal(pageInfo.getTotal());
        customPageInfo.setPageNum(pageInfo.getPageNum());
        customPageInfo.setPageSize(pageInfo.getPageSize());
        customPageInfo.setPages(pageInfo.getPages());
        customPageInfo.setSize(pageInfo.getSize());
        customPageInfo.setHasNextPage(pageInfo.isHasNextPage());
        customPageInfo.setHasPreviousPage(pageInfo.isHasPreviousPage());
        customPageInfo.setFirstPage(pageInfo.isIsFirstPage());
        customPageInfo.setLastPage(pageInfo.isIsLastPage());
        customPageInfo.setNavigatepageNums(pageInfo.getNavigatepageNums());
        customPageInfo.setShowList(pageInfo.getList());
        return customPageInfo;
    }

    /**
     * @author   创建人：路逸冰(GIT:luyibing)
     * @date	 创建时间：2019/11/20 19:41
     * @Description	创建内容：(当需要在代码中分页的时候，使用此方法可满足分页)
     * @modify   修改人：姓名(SVN/GIT账户)
     * @date	 修改时间：2019/11/20 19:41(格式遵从创建时间)
     * @Description 修改内容：(这里用一句话描述这个函数修改的内容)
     * @tittle   方法名：
     * @param    pageList 集合泛型对象
     * @param    pageNum 当前页码
     * @param    pageSize 当前页数
     * @return   返回值：CustomPageInfo
     * @return_description  返回值说明：(这里用一句话描述这个函数返回值的内容)
     * @version  版本号：1.0.0
     */
    public static <T> CustomPageInfo<T> getRewritePageInfo(List<T> pageList,
                                                           Integer pageNum,
                                                           Integer pageSize){
        //重新创建分页对象
        CustomPageInfo<T> customPageInfo = new CustomPageInfo<>();
        customPageInfo.setTotal(pageList.size());
        //当前页码，默认1
        customPageInfo.setPageNum(pageNum);
        //页面显示条数，默认20
        customPageInfo.setPageSize(pageSize);
        Double totalPages = (double) pageList.size() / (double) pageSize;
        //如果等于0代表整数，直接设置页数，如果不等于0，就将页数加1
        if(totalPages.intValue()-totalPages == 0){
            customPageInfo.setPages(totalPages.intValue());
        } else{
            customPageInfo.setPages(totalPages.intValue() + 1);
        }
        //当前页面一共几条
        customPageInfo.setSize(pageSize);
        //是否有下一页
        customPageInfo.setHasNextPage((customPageInfo.getPages() - pageNum) == 0 ? false : true);
        //是否有上一页
        customPageInfo.setHasPreviousPage((1 - pageNum) == 0 ? false : true);
        //是否是第一页面
        customPageInfo.setFirstPage((1 - pageNum) == 0 ? true : false);
        //是否是最后一页
        customPageInfo.setLastPage((customPageInfo.getPages() - pageNum) == 0 ? true : false);
        //循环将所有页数添加到navigatepageNums数组中作为导航页
        int[] navigatepageNums = new int[customPageInfo.getPages()];
        for (int i = 0; i < navigatepageNums.length; i++) {
            navigatepageNums[i] = i+1;
        }
        //页码数组
        customPageInfo.setNavigatepageNums(navigatepageNums);
        //如果是最后一页直接将list的size添加到参数中，否则就正常计算
        int lastPageNum;
        if(pageNum == customPageInfo.getPages()){
            lastPageNum = pageList.size();
        } else{
            lastPageNum = pageNum * pageSize;
        }
        /**
         * 集合数据(下一页起始位置(当前页码 * 当前页显示条数 - 当前页显示条数))
         * 避免出现页数不存在的情况下查不到数据出现 500的错误异常
         * 所以添加了对于截取的下标做了判断，当需要截取的下标不存在时，集合数组为空，当截取下标存在时，程序正常执行
         */
        int i = pageNum * pageSize - pageSize == 0 ? 0 : pageNum * pageSize - pageSize;
        if(i<pageList.size() && i>=0){
            customPageInfo.setShowList(pageList.subList(
                    pageNum * pageSize - pageSize == 0 ? 0 : pageNum * pageSize - pageSize,lastPageNum));
        }else {
            List pageNullList=new ArrayList();
            customPageInfo.setShowList(pageNullList);
        }
        return customPageInfo;
    }

    /**
     * 构建统一分页对象，已知以下信息
     * @param pageList：当前页数据
     * @param total：总页数
     * @param records：总记录数
     * @param pageNum：当前页码
     * @param pageSize：每页记录数
     * @param <T>
     * @return
     */
    public static <T> CustomPageInfo<T> getPageInfo(List<T> pageList, Integer total, Integer records, Integer pageNum, Integer pageSize){
        //重新创建分页对象
        CustomPageInfo<T> customPageInfo = new CustomPageInfo<>();
        customPageInfo.setTotal(records);
        //当前页码，默认1
        customPageInfo.setPageNum(pageNum);
        //页面显示条数，默认20
        customPageInfo.setPageSize(pageSize);
        customPageInfo.setPages(total);
        //当前页面一共几条
        customPageInfo.setSize(pageList.size());
        //是否有下一页
        customPageInfo.setHasNextPage((customPageInfo.getPages() - pageNum) == 0 ? false : true);
        //是否有上一页
        customPageInfo.setHasPreviousPage((1 - pageNum) == 0 ? false : true);
        //是否是第一页面
        customPageInfo.setFirstPage((1 - pageNum) == 0 ? true : false);
        //是否是最后一页
        customPageInfo.setLastPage((customPageInfo.getPages() - pageNum) == 0 ? true : false);
        //循环将所有页数添加到navigatepageNums数组中作为导航页
        int[] navigatepageNums = new int[customPageInfo.getPages()];
        for (int i = 0; i < navigatepageNums.length; i++) {
            navigatepageNums[i] = i+1;
        }
        //页码数组
        customPageInfo.setNavigatepageNums(navigatepageNums);
        //如果是最后一页直接将list的size添加到参数中，否则就正常计算
        int lastPageNum;
        if(pageNum == customPageInfo.getPages()){
            lastPageNum = pageList.size();
        } else{
            lastPageNum = pageNum * pageSize;
        }
        //集合数据
        customPageInfo.setShowList(pageList);
        return customPageInfo;
    }

}
