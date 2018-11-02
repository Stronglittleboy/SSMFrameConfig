package com.service;

import com.bean.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RoleService {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    public PageInfo getall(int pageindex, int size) ;

    int insert(int[] ids, String rolename, Integer rolestate);

    Role selectbyKey(Integer roleid);

    int updateRole(Role role, int[] menuids);
}