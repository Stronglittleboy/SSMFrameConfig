package com.service.Impl;

import com.bean.Menu;
import com.bean.Role;
import com.dao.RoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.MiddleService;
import com.service.RoleService;
import com.util.MenuSortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class  RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MiddleService middleService;

    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        return roleMapper.deleteByPrimaryKey(roleid);
    }

    @Override
    public int insert(Role record) {
        return 0;
    }

    @Override
    public int insertSelective(Role record) {
        return 0;
    }

    @Override
    public Role selectByPrimaryKey(Integer roleid) {
        return null;
    }

    @Override
    public PageInfo getall(int pageindex, int size) {
        PageHelper.startPage(pageindex,size);
        Map map=new HashMap();
        List<Role> list = roleMapper.findall(map);
        PageInfo pi=new PageInfo(list);
        return pi;
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return 0;
    }

    @Transactional
    @Override
    public int insert(int[] ids,String rolename,Integer rolestate) {
        Role role = new Role();
        role.setRolename(rolename);
        role.setRolestate(rolestate);
        int insert = roleMapper.insert(role);
        Map map = new HashMap();
        map.put("roleid",role.getRoleid());
        map.put("ids",ids);
        int middle= middleService.insertRM(map);
        if (middle>0&&insert==1){
        return 1;
        }
        return 0;
    }

    @Override
    public Role selectbyKey(Integer roleid) {
        Role role = roleMapper.selectbyKey(roleid);
        List<Menu> menus  = role.getMenus();
        role.setMenus(MenuSortUtil.sortMenu(menus));
        return role;
    }
    @Transactional
    @Override
    public int updateRole(Role role, int[] menuids) {
         int rs=roleMapper.updateByPrimaryKeySelective(role);
        int i = middleService.updateMiddle(role.getRoleid(), menuids);
        if(rs==1&&i>=1){
        return 1;
        }
        else {
            return 0;
        }
    }
}