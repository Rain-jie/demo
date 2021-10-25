package com.deal.demo.dao;

import com.deal.demo.model.Journalism;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JournalismMapper {
    List<Journalism> getJournalism();

    int insertJournalism(Journalism journalism);

    int updateJournalism(Journalism journalism);

    int deleteJournalism(Integer journalismId);
}
