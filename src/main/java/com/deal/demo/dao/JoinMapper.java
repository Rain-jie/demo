package com.deal.demo.dao;

import com.deal.demo.model.Join;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JoinMapper {
    List<Join> getJoinActivity();

    int insertJoin(Join join);

    int updateJoinActivity(Join join);

    int deleteJoinActivity(Integer joinActivityId);
}
