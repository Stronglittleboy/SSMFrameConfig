package com.web;

import com.service.ActivityService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    /*跳转到部署管理*/
    @RequestMapping("/bushu/getdeploy")
    public String  getdeploy(ModelMap map){
        /*获得部署信息列表*/
        List<Deployment> deplist = activityService.getdeplist();
        map.put("dlist",deplist);
        /*获得流程定义列表*/
        List<ProcessDefinition> prolist = activityService.getprolist();
        map.put("prolist",prolist);
        return "/bushu/list";
    }
//    跳转到任务管理
    @RequestMapping("/bushu/toadd")
    public String toadd(MultipartFile depfile, String filename){
        return "/renwu/list";
    }
//    跳转到请假管理
    @RequestMapping("/bushu/getlist")
    public String getlist(){
        return "/qingjia/list";
    }
    //上传流程文件
    @RequestMapping("/bushu/adddeploy")
    public String up(MultipartFile depfile, String name){
        try {
            activityService.add(depfile.getInputStream(),name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/bushu/getdeploy";
    }
    /*删除部署文件*/
    @RequestMapping("/bushu/delete")
    public void delete(String id, HttpServletResponse resp){
        int i = activityService.deletedeploy(id);
        resp.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter ou = resp.getWriter();
            if (i>0){
                ou.write("<script>alert('删除成功');location.href='/bushu/getdeploy'</script>");
            }else {
                ou.write("<script>alert('删除失败');location.href='/bushu/getdeploy'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/bushu/lookimg")
    public void getimg(String  id,String imagename,HttpServletResponse resp){
        System.out.println(imagename);
        InputStream inputStream = activityService.findimage(id,imagename);
        try {
            OutputStream outputStream =resp.getOutputStream();
            int k=-1;
            while((k=inputStream.read())!=-1){
                outputStream.write(k);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/bushu/img")
    public String getimg(String id,String imgname,ModelMap map){
        map.put("id",id);
        map.put("imagename",imgname);
        return "/bushu/image";
    }
}
