package com.service;

import com.bean.Menu;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface MenuService {
    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    /*通过角色id搜索该角色的所有权限的菜单*/
    List<Menu> getall(int roleid);
    /*获得所有的菜单目录*/
    List<Menu> findall();
    /*获得所有菜单目录：不经过分级的*/
    PageInfo show(int pageindex, int size);
//    通过menuid查询菜单详情
    Menu selectinfo(int menuid);
    /*获取一级菜单*/
    List<Menu> selectUpmenu();
    //通过字段查询
    List<Menu> selectByField(Map map);
}