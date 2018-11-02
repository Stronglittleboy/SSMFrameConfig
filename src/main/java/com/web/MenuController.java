package com.web;

import com.bean.Menu;
import com.bean.Middle;
import com.github.pagehelper.PageInfo;
import com.service.MenuService;
import com.service.MiddleService;
import com.util.MenuSortUtil;
import com.util.WriteToPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private MiddleService middleService;
    @RequestMapping("/power/menu/list")
    public String getlist(@RequestParam(value="index",defaultValue = "1") int pageindex,
                          ModelMap map,
                          @RequestParam(value="size",defaultValue = "5") int size){
        PageInfo pageinfo = menuService.show(pageindex, size);
        map.put("pi",pageinfo);
        return "/power/menu/list";
    }
    /*到详情页面*/
    @RequestMapping("/power/menu/info")
    public String toInfo(int menuid,ModelMap map){
        Menu menu = menuService.selectByPrimaryKey(menuid);
        System.out.println(menu.getMenuname()+"=="+menu.getUpmenuid());
        map.put("menu",menu);
        System.out.println(menu.getMenustate()+"===");
        return "/power/menu/info";
    }
    @RequestMapping("/power/menu/edit")
    public String toedit(int menuid,ModelMap map){
        Menu menu = menuService.selectByPrimaryKey(menuid);
        map.put("menu",menu);
        /*获得所有一级菜单menuid*/
        List<Menu> upmenu = menuService.selectUpmenu();
        Iterator<Menu> iterator = upmenu.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getMenuid()==menuid){
                iterator.remove();
            }
        }
        map.put("upmenu",upmenu);
        return "/power/menu/edit";
    }
    @RequestMapping("/power/menu/delete")
    public void todelete(int menuid, HttpServletResponse resp){
        System.out.println("jkjlkjkl");
        resp.setContentType("text/html;charset=utf-8");
        Map map=new HashMap();
        map.put("menuid",menuid);
        Menu menu = menuService.selectByField(map).get(0);
        System.out.println(menu.getMenuname());
        try {
            PrintWriter ou = resp.getWriter();
            System.out.println(menu.getUpmenuid());
            if(menu.getUpmenuid()!=-1){
                menuService.deleteByPrimaryKey(menuid);
                middleService.deleteByField(map);
                ou.write("<script >alert('已经删除');location.href='/power/menu/list'</script>");
            }else {
                Map twomap=new HashMap();
                twomap.put("upmenuid",menuid);
                List<Menu> menus = menuService.selectByField(twomap);
                System.out.println(menus.size()+"===");
                if(menus.size()>0){
                    System.out.println("冲过");
                    ou.write("<script>alert('请清除所属二级菜单');location.href='/power/menu/edit?menuid="+menuid+"'</script>");
                }else {
                    menuService.deleteByPrimaryKey(menuid);
                    ou.write("<script>alert('删除成功');location.href='/power/menu/list'</script>");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/power/menu/doedit")
    public void doedit(Menu menu,HttpServletResponse resp){
        System.out.println(menu.getMenupath());
        int i = menuService.updateByPrimaryKey(menu);
        System.out.println(i);
        Map<String,String> map=new LinkedHashMap<String, String>();
        map.put("修改成功","/power/menu/list");
        map.put("修改失败","/power/menu/edit");
        WriteToPageUtil.printTopage(resp,map,i);
    }
    @RequestMapping("/power/menu/toadd")
    public String toadd(ModelMap map){
        Map map1=new HashMap();
        map1.put("upmenuid",-1);
        List<Menu> menus = menuService.selectByField(map1);
        map.put("menus",menus);
        return "/power/menu/add";
    }
    @RequestMapping("/power/menu/add")
    public void add(HttpServletResponse response,Menu menu){
        System.out.println(menu.getMenuname());
        int insert = menuService.insert(menu);
        System.out.println(insert);
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
           Map map = new LinkedHashMap<String,String>();
           map.put("添加成功","/power/menu/list");
           map.put("添加失败","/power/menu/toadd");
            WriteToPageUtil.printTopage(response,map,insert);
//            if(insert>0){
////                writer.write("<script>alert('添加成功');location.href='/power/menu/list'</script>");
////            }else {
////                writer.write("<script>alert('添加失败');location.href='/power/menu/toadd'</script>");
////            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/power/menu/batchdelte")
    public void batchdelet(String[] midAuid){
        StringBuffer stubu = new StringBuffer();
        for (int i = 0; i < midAuid.length; i++) {
            System.out.println(midAuid[i]);
            stubu.append(midAuid);
        }
        String str="[{\n" +
                "            \"firstName\": \"John\",\n" +
                "                    \"lastName\": \"Doe\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"firstName\": \"Anna\",\n" +
                "                \"lastName\": \"Smith\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"firstName\": \"Peter\",\n" +
                "                \"lastName\": \"Jones\"\n" +
                "        }\n" +
                "]";
    }
}
