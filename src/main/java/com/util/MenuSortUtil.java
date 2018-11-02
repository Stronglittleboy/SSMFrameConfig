package com.util;

import com.bean.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuSortUtil {
    public static List<Menu> sortMenu(List<Menu> initlist) {
        List<Menu> rslist = new ArrayList<Menu>();
        for (Menu m : initlist) {
            if (m.getUpmenuid() == -1) {
                List<Menu> menus = new ArrayList<Menu>();
                for (Menu menu2 : initlist) {
                    if (menu2.getUpmenuid() == m.getMenuid()) {
                        menus.add(menu2);
                    }
                }
                m.setMenus(menus);
                rslist.add(m);
            }
        }
        return rslist;
    }
    public static List<Menu> openMenu(List<Menu> initlist) {
        List<Menu> rslist = new ArrayList<Menu>();
        for (Menu m : initlist) {
            rslist.add(m);
                for (Menu menu2 : m.getMenus()) {
                    rslist.add(menu2);
                }
        }
        return rslist;
    }
}
