package com.deal.demo.dao;

import com.deal.demo.model.ActivityFunds;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityFundsMapper {
    List<ActivityFunds> getActivityFunds();

    int registerActivityFunds(ActivityFunds activityFunds);

    int updateActivityFunds(ActivityFunds activityFunds);

    int deleteActivityFunds(Integer activityFundsId);
}
