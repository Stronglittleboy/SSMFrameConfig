package com.web;

import com.bean.Menu;
import com.bean.Middle;
import com.bean.Role;
import com.bean.UserTb;
import com.github.pagehelper.PageInfo;
import com.service.MenuService;
import com.service.MiddleService;
import com.service.RoleService;
import com.service.UserTbService;
import com.util.MenuSortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 关于角色的所有操作
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MiddleService middleService;
    @Autowired
    private UserTbService userTbService;
    /*到角色管理页面*/
    @RequestMapping("/power/role/getlist")
    public String getlist(
                          @RequestParam(value="index",defaultValue = "1") int pageindex,
                          ModelMap map,
                          @RequestParam(value="size",defaultValue = "5") int size){

        PageInfo pageInfo = roleService.getall(pageindex, size);
        pageInfo.setNavigatePages(3);
        map.put("pi",pageInfo);
        map.put("size",size);
        return "/power/role/list";
    }
    /**
     * create by: mmzs
     * description:该方法是获取菜单目录，返回页面添加角色权限add.jap
     * create time: 17:39 2018/10/23
     *
     * @Param: map
     * @return java.lang.String
     */
    @RequestMapping("/power/user/add")
    public String toadd(ModelMap map){
        List<Menu> menus = menuService.findall();
        map.put("menus",menus);
        return "/power/role/add";
    }
    /**
     * create by: mmzs
     * description:这个方法是添加角色，包括权限分配
     * create time: 21:28 2018/10/23
     *
     * @Param: menuids
     * @Param: rolename
     * @Param: rolestate
     * @return void
     */
    @RequestMapping("/power/role/add")
    public void add(int[] menuid, String rolename, Integer rolestate, HttpServletResponse resp){
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter ou=null;
        int insert = roleService.insert(menuid, rolename, rolestate);
        try {
             ou= resp.getWriter();
             if(insert==1) {
                 ou.print("<script>alert('添加角色成功');location.href='/power/user/getlist'</script>");
             }else{
                 ou.print("<script>alert('添加失败');location.href='/power/role/add'</script>");
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*跳到详情页面*/
    @RequestMapping("/power/role/details")
    public String getdetails(int roleid,ModelMap map){
        Role role = roleService.selectbyKey(roleid);
        map.put("menus",role.getMenus());
        map.put("role",role);
        return "/power/role/info";
    }
    /*去修改权限*/
    @RequestMapping("/power/role/toedit")
    public String getdeit(int roleid,ModelMap map){
        Role role = roleService.selectbyKey(roleid);
        List<Menu> menus = menuService.findall();
        map.put("role",role);
        map.put("menus",menus);
        return "/power/role/edit";
    }
    /*修改权限*/
    @RequestMapping("/power/role/edit")
    public String setEdit(int[] menuid,Role role,ModelMap map){
        for (int m : menuid) {
            System.out.println("m"+m);
        }
        roleService.updateRole(role,menuid);
       /*,List<Menu> oldmenus提供一种方案，从前台获取所有旧的菜单对象，然后跟新的菜单对象ids对比，减少的放入一个集合，然后删除操作，多的插入操作*/
        return "redirect:/power/role/details?roleid="+role.getRoleid();
    }
    /*删除角色：首先判断该角色是否还有用户使用，没有才可以删除该角色，同时删除该角色对应菜单权限表*/
    @RequestMapping("/power/role/deleterole")
    public void deleterole(int roleid,HttpServletResponse resp){
        List<UserTb> list = userTbService.selectByRoleid(roleid);
        System.out.println(list.size()+"===");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter ou =null;
        try {
            ou= resp.getWriter();
            if (list.size()>0){
                ou.print("<script>alert('还有用户正在使用该角色，请先删除该角色的用户');location.href='/power/user/userlist'</script>");
            }else {
                int i = roleService.deleteByPrimaryKey(roleid);
                middleService.deleteByRoleid(roleid);
                List<Middle> middles = middleService.selectByRoleid(roleid);
                System.out.println("i:"+i+"===="+middles.size());
                if(i==1&&middles.size()==0){
                    ou.print("<script>alert('已删除该角色');location.href='/power/user/getlist'</script>\"");
                }else {
                    ou.print("<script>alert('删除失败');location.href='/power/user/getlist'</script>");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
