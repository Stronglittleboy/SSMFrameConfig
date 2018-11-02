package com.dao;

import com.bean.Menu;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> searchroleid(int roleid);

    List<Menu> findall(Map map);

    int insertMiddle(Map map);

    Menu selectinfo(int menuid);

    /*获取一级菜单*/
    List<Menu> selectUpmenu(int menustate);
    /*通过字段查询*/
    List<Menu> selectByField(Map map);
}