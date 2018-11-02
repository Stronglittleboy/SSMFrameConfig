package com.web;

import com.bean.Classes;
import com.bean.Major;
import com.bean.UserTb;
import com.github.pagehelper.PageInfo;
import com.service.ClassesService;
import com.service.DepartmentService;
import com.service.MajorService;
import com.service.UserTbService;
import com.util.ExcelUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private UserTbService userTbService;
    @RequestMapping("/Educational/class/getmajiorbydid")
    public List<Deprecated> getmajiobydid(){
        System.out.println("lj");
        return null;
    }
    /*获取班级信息，并且获取分页等信息，返回当前页面所需list*/
    @RequestMapping("/Educational/class/getclasslist")
    public String getclasslist(String classname, String classnum,
                               @RequestParam(value="index",defaultValue = "1") int pageindex,
                               ModelMap map,
                               @RequestParam(value="size",defaultValue = "5") int size){
        PageInfo getall = classesService.getall(classname,classnum,pageindex,size,null,null);
        map.put("pi",getall);
        map.put("cname",classname);
        map.put("cnum",classnum);
        map.put("size",size);
        System.out.println(classname+":"+classnum+":"+size);
        return "/Educational/class/list";
    }
    /*新增班级*/
    /*获取部门*/
    @RequestMapping("/Educational/class/getDepts")

    public String getDepts(ModelMap map){
        List list= departmentService.findall();
        map.put("dlist",list);
        return "/Educational/class/add";
    }
    /*获得专业:因为是ajax请求，直接返回一个数据就可以，前台处理*/
    @RequestMapping("/Educational/class/getmajorbydid")
    @ResponseBody
    public List getMajorByid(int did){
        List<Major> list = majorService.findbydeptid(did);
        return list;
    }
    @RequestMapping("/Educational/class/getteacher")
    @ResponseBody
    public List getteacher(int did,int mid){
        System.out.println("发出请求");
        List tlist = userTbService.findall(did, mid,"班主任");
        return tlist;
    }
    //新增班级
    @RequestMapping("/Educational/class/addclass")
    public String add(Classes classes){
        classes.setClassstate("未审核");
        classesService.insert(classes);
        return "redirect:/Educational/class/getclasslist";
    }
    /*导出Excel*/
    @RequestMapping("/Educational/class/doexcel")
    public void doexcel(int[] classid, HttpServletResponse response){
        System.out.println(classid);
        PageInfo pg= classesService.getall(null,null,0,0,classid,null);
        List<Classes> list=pg.getList();
        ExcelUtil.headers=new String[]{"院系","班级编号","班级名称","班主任老师","人数","班级状态"};
        ExcelUtil.createhead(6);
        ExcelUtil.createother(list);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
        String date= simpleDateFormat.format(new Date());
        FileOutputStream out= null;
        try {
            out = new FileOutputStream("f:\\class"+date+".xls");
            ExcelUtil.export(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out2=response.getWriter();
            out2.print("<script>alert('导出成功');location.href='/Educational/class/getclasslist'</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
