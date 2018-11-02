package com.dao;

import com.bean.Menu;
import com.bean.Middle;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;

public interface MiddleMapper {
    int deleteByPrimaryKey(Integer middleid);

    int insert(Middle record);

    int insertSelective(Middle record);

    Middle selectByPrimaryKey(Integer middleid);

    List<Middle> selectByRoleid(Integer roleid);

    int updateByPrimaryKeySelective(Middle record);

    int updateByPrimaryKey(Middle record);

    int insertMiddle(Map map);

    int deleteByroleid(int roleid);
    /*通过字段查询*/
    List<Middle> selectByField(Map map);
//    通过字段删除
    int deleteByField(Map map);
}