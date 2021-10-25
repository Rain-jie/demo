package com.deal.demo.service;

import java.util.HashMap;
import java.util.Map;

public interface ActivityFundsService {
    Map<String, Object> getActivityFunds(HashMap<String, Object> userMap);

    Map<String, Object> registerActivityFunds(Map<String, Object> userJsonMap);

    Map<String, Object> updateActivityFunds(Map<String, Object> userJsonMap);

    Map<String, Object> deleteActivityFunds(Integer activityFundsId);
}
