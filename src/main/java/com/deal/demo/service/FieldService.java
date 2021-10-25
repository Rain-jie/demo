package com.deal.demo.service;

import java.util.HashMap;
import java.util.Map;

public interface FieldService {
    Map<String, Object> getField(HashMap<String, Object> userMap);

    Map<String, Object> registerField(Map<String, Object> userJsonMap);

    Map<String, Object> updateField(Map<String, Object> userJsonMap);

    Map<String, Object> deleteField(Integer fieldId);
}
