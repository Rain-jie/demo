package com.deal.demo.dao;

import com.deal.demo.model.Field;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FieldMapper {
    int deleteField(Integer fieldId);

    int updateField(Field field);

    int insertField(Field field);

    List<Field> getField();

}
