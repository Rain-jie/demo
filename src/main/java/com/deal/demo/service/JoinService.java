package com.deal.demo.service;

import java.util.HashMap;
import java.util.Map;

public interface JoinService {
    Map<String, Object> getJoinActivity(HashMap<String, Object> userMap);

    Map<String, Object> registerJoinActivity(Map<String, Object> userJsonMap);

    Map<String, Object> updateJoinActivity(Map<String, Object> userJsonMap);

    Map<String, Object> deleteJoinActivity(Integer joinActivityId);
}
