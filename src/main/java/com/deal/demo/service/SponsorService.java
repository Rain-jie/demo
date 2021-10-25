package com.deal.demo.service;

import java.util.HashMap;
import java.util.Map;

public interface SponsorService {
    /**
     * 获取赞助企业方法
     * @param userMap
     * @return
     */
    Map<String, Object> getSponsor(HashMap<String, Object> userMap);
    /**
     * 新增赞助企业
     * @return
     */
    Map<String, Object> registerSponsor(Map<String, Object> userJsonMap);
    /**
     * 赞助企业信息修改
     * @return
     */
    Map<String, Object> updateSponsor(Map<String, Object> userJsonMap);

    /**
     * 清除赞助企业信息
     * @param sponsorId
     * @return
     */
    Map<String, Object> deleteSponsor(Integer sponsorId);
}
