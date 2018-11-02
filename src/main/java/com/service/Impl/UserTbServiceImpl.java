package com.service.Impl;

import com.bean.Menu;
import com.bean.Role;
import com.bean.UserTb;
import com.dao.UserTbMapper;
import com.service.MenuService;
import com.service.UserTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserTbServiceImpl implements UserTbService {
    @Autowired
    private UserTbMapper mapper;
    @Autowired
    private MenuService menuService;
    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return mapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(UserTb record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(UserTb record) {
        return mapper.insertSelective(record);
    }

    @Override
    public UserTb selectByPrimaryKey(Integer userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserTb record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserTb record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public UserTb login(UserTb userTb) {
        System.out.println("service"+userTb.getUserName());
        UserTb tb = mapper.login(userTb.getUserName());
        if ( tb != null &&tb.getUserPs().equals(userTb.getUserPs())) {
                if (tb.getRole().getRolestate()==1){
                    List<Menu> list = menuService.getall(tb.getRoleId());
                    Role role=tb.getRole();
                    /*设置角色*/
                    role.setMenus(list);
                    tb.setRole(role);
                    //修改登录次数
                    tb.setLogincount(tb.getLogincount()+1);
                    mapper.updateByPrimaryKeySelective(tb);
                    return tb;
                }
            else {
                return null;
                }
        }
        return null;
    }

    @Override
    public List findall(int did, int mid, String rolename) {
        Map map=new HashMap();
        map.put("did",did);
        map.put("mid",mid);
        map.put("rolename",rolename);
        return mapper.findall(map);
    }

    @Override
    public List<UserTb> selectByRoleid(Integer roleid) {
        return mapper.selectByRoleid(roleid);
    }
}
