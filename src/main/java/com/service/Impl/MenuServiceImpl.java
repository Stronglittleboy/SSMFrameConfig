package com.service.Impl;

import com.bean.Menu;
import com.dao.MenuMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.MenuService;
import com.util.MenuSortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(Integer menuid) {
        return menuMapper.deleteByPrimaryKey(menuid);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuid) {
        return menuMapper.selectByPrimaryKey(menuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Menu> getall(int roleid) {
        /*将得到的菜单进行分类处理，返回菜单集合*/
        List<Menu> initlist = menuMapper.searchroleid(roleid);
        List<Menu> rslist=new ArrayList<Menu>();
        for (Menu m : initlist) {
            if (m.getUpmenuid()==-1){
            List<Menu> menus=new ArrayList<Menu>();
                for (Menu menu2 : initlist) {
                    if(menu2.getUpmenuid()==m.getMenuid()){
                        menus.add(menu2);
                    }
                }
                m.setMenus(menus);
                rslist.add(m);
            }
        }
        return rslist;
    }

    @Override
    public List<Menu> findall() {
        Map map=new HashMap();
        /*将得到的菜单进行分类处理，返回菜单集合*/
        List<Menu> initlist = menuMapper.findall(map);

        return MenuSortUtil.sortMenu(initlist);
    }

    @Override
    public PageInfo show(int pageindex, int size) {
        PageHelper.startPage(pageindex,size);
        Map map=new HashMap<>();
        map.put("pageindex",pageindex);
        map.put("size",size);
        List<Menu> list = menuMapper.findall(map);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Menu selectinfo(int menuid) {
        return menuMapper.selectinfo(menuid);
    }

    @Override
    public List<Menu> selectUpmenu() {
        int upmenuid=-1;
        return   menuMapper.selectUpmenu(upmenuid);
    }

    @Override
    public List<Menu> selectByField(Map map) {
        return menuMapper.selectByField(map);
    }
}
