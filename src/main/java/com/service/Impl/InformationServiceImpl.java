package com.service.Impl;

import com.bean.Classes;
import com.bean.Information;
import com.dao.InformationMapper;
import com.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;
    @Override
    public int deleteByPrimaryKey(Integer informationid) {
        return 0;
    }

    @Override
    public int insert(Information record) {
        return informationMapper.insert(record);
    }

    @Override
    public int insertSelective(Information record) {
        return 0;
    }

    @Override
    public Information selectByPrimaryKey(Integer informationid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Information record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Information record) {
        return 0;
    }

    @Override
    public List<Information> getall(Map map) {
        return informationMapper.getall(map);
    }
}
