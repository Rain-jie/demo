package com.deal.demo.service;

import java.util.HashMap;
import java.util.Map;

public interface JournalismService {
    Map<String, Object> getJournalism(HashMap<String, Object> userMap);

    Map<String, Object> registerJournalism(Map<String, Object> userJsonMap);

    Map<String, Object> updateJournalism(Map<String, Object> userJsonMap);

    Map<String, Object> deleteJournalism(Integer journalismId);
}
