package com.web;

import com.bean.Classes;
import com.bean.Problem;
import com.bean.UserTb;
import com.github.pagehelper.Page;
import com.service.ProblemService;
import com.service.StudentService;
import com.service.UserTbService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
@SessionAttributes({"userbean","logintime"})
public class UserTbController {
    @Autowired
    private UserTbService userTbServicee;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ProblemService problemService;

    final int problemid=1;
    @RequestMapping("/login")
    public void login(HttpServletResponse resp, ModelMap map,UserTb tb, String DropExpiration){
        System.out.println("进入。。。。。。");
        System.out.println("保存时间是"+DropExpiration);
        System.out.println("用户名"+tb.getUserName()+"密码"+tb.getUserPs());
        UserTb userbean = userTbServicee.login(tb);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter ou = null;
        try {
            ou = resp.getWriter();
            if (userbean!=null){
                map.addAttribute("userbean",userbean);
                Date logintime = new Date();
                map.addAttribute("logintime",logintime);
                Cookie c = new Cookie("uname",userbean.getUserName());
                if (DropExpiration.equals("Day")){
                    c.setMaxAge(24*60*60);
                }else if(DropExpiration.equals("Month")){
                    c.setMaxAge(24*60*60*31);
                }else if(DropExpiration.equals("Year")){
                    c.setMaxAge(24*60*60*365);
                }
                ou.write("<script>alert('登录成功');location.href='index.jsp'</script>");
            }
            else {
                ou.write("<script>alert('用户名或密码不正确');location.href='login.jsp'</script>\"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/exit")
    public String exit(SessionStatus status){
        status.setComplete();
        return "redirect:login.jsp";
    }
    /*更新用户信息操作*/
    @RequestMapping("/user/update")
    public void updateUser(UserTb tb,HttpServletResponse resp,ModelMap map){

        System.out.println("进入update");
        System.out.println(tb);
        int i = userTbServicee.updateByPrimaryKeySelective(tb);
        resp.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter ou = resp.getWriter();
            if (i==1){
//                UserTb userbean = (UserTb) map.get("userbean");
                UserTb userTb = userTbServicee.selectByPrimaryKey(tb.getUserId());
                map.addAttribute("userbean",userTb);
                ou.write("<script>alert('修改成功');top.location.href='/index.jsp'</script>");
            }else {
                ou.write("<script>alert('修改失败');top.location.href='MyUser.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/user/updatepassword")
    public void updatepassword(HttpServletResponse resp,String userPs,String password,String RenewPwd,SessionStatus status,UserTb tb){
        System.out.println(userPs+":"+password+""+RenewPwd);
        System.out.println(tb);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter ou=null;
        try {
            ou = resp.getWriter();
        if (!userPs.equals(RenewPwd)){
            ou.write("<script >alert('两次输入密码不一致');location.href='password.jsp'</script>");
            System.out.println("两次输入密码不一致");
        }else {
            if (!userPs.equals(password)){
                System.out.println("开始更新密码");
                int i = userTbServicee.updateByPrimaryKeySelective(tb);
                if (i==1){
                    status.setComplete();
                    ou.write("<script >alert('修改成功，请重新登录');top.location.href='/login.jsp'</script>");}
                else {
                    ou.write("<script >alert('修改失败');location.href='password.jsp'</script>");
                }
            }else {
                ou.write("<script >alert('与原密码一致，请重新输入');location.href='password.jsp'</script>");
                System.out.println("与原密码一次");
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*获取班级信息*/
    /*查询用户表,获取学生id，查询学生表和班级表，的信息*/
    @RequestMapping("user/class")
    public String getClassInfo(@ModelAttribute("userbean")UserTb userTb, ModelMap map){
        Classes stuClass = studentService.getStuClass(userTb.getStudentId());
        map.addAttribute("classinfo",stuClass);

        return "/user/class";
    }
    /*提交问题：投诉或者提问*/
    @RequestMapping("user/problem")
    public  void getProblem(Problem problem,HttpServletResponse resp){
        System.out.println("进入");
        System.out.println(problem);
        System.out.println(problem.getProblemtype()+":"+problem.getProblemcontent());
        int insert = problemService.insert(problem);
        resp.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter ou = resp.getWriter();
            if (insert==1){
                ou.write("<script >alert('提交成功');location.href='user/class.jsp'</script>");
            }else {
                ou.write("<script >alert('提交失败');location.href='/user/class.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*用户权限管理模块*/

    /*用户信息列表*/
    @RequestMapping("/power/user/userlist")
    public String userlist(){
        return "";
    }
}
