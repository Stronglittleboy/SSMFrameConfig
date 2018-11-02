package com.service;

import com.bean.Classes;
import com.bean.Information;

import java.util.List;
import java.util.Map;

public interface InformationService {
    int deleteByPrimaryKey(Integer informationid);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer informationid);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);

    List<Information> getall(Map map);
}
