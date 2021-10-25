package com.deal.demo.dao;

import com.deal.demo.model.Sponsor;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SponsorMapper {
    /**
     * 根据用户ID获取该用户所得到的赞助企业
     * @param sponsorMap
     * @return
     */
    List<Sponsor> getSponsor(HashMap<String, Object> sponsorMap);

    /**
     * 新增赞助企业信息
     * @param sponsor
     * @return
     */
    int insertSponsor(Sponsor sponsor);

    /**
     * 根据主键ID获取此赞助企业信息是否存在
     * @param sponsorId
     * @return
     */
    Sponsor selectSponsor(Integer sponsorId);

    /**
     * 更新赞助企业信息
     * @param sponsor
     * @return
     */
    int updateSponsor(Sponsor sponsor);

    /**
     * 清除赞助企业信息
     * @param sponsorId
     * @return
     */
    int deleteSponsor(Integer sponsorId);
}
