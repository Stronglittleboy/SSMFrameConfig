package com.service;

import com.bean.Department;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DepartmentService {
    int deleteByPrimaryKey(Integer departid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    //查询全部的方法
    public List<Department> findall();
}