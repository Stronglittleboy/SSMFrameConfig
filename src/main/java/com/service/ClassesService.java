package com.service;

import com.bean.Classes;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ClassesService {

    int deleteByPrimaryKey(Integer classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    public PageInfo getall(String name, String classnum, int pageindex, int size, int[] ids, String state);
}