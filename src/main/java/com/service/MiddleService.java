package com.service;

import com.bean.Middle;

import java.util.List;
import java.util.Map;

public interface MiddleService {
    int deleteByPrimaryKey(Integer middleid);
    int deleteByRoleid(Integer roleid);

    int insert(Middle record);

    int insertSelective(Middle record);

    Middle selectByPrimaryKey(Integer middleid);

    List<Middle> selectByRoleid(Integer roleid);

    int updateByPrimaryKeySelective(Middle record);

    int updateByPrimaryKey(Middle record);

    int insertRM(Map map);

    int updateMiddle(int roleid, int[] menuids);

    /*通过字段查询*/
    List<Middle> selectByField(Map map);

    int deleteByField(Map map);
}