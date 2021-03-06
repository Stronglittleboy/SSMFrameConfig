package com.dao;

import com.bean.Classes;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
    /*传递参数，查询所有的*/
    List<Classes> getall(Map map);

}