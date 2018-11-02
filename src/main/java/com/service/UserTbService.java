package com.service;

import com.bean.UserTb;

import java.util.List;

public interface UserTbService {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Integer userId);

    /*通过roleid查询用户*/
    List<UserTb> selectByRoleid(Integer roleid);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);

    UserTb login(UserTb userTb);

    public List findall(int did, int mid, String rolename);

}
