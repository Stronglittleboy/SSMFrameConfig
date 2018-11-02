package com.web;

import com.bean.Leavebill;
import com.bean.UserTb;
import com.service.LeavebillService;
import com.util.WriteToPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LeaveBillsController {
    @Autowired
    private LeavebillService leavebillService;
    @RequestMapping("/qingjia/getleavebills")
    public String findall(HttpSession session, ModelMap map){
        UserTb userbean = (UserTb) session.getAttribute("userbean");
        Map map1 = new HashMap();
        map1.put("userid",userbean.getUserId());
        List<Leavebill> list = leavebillService.getallbyfield(map1);
        map.put("leavelist",list);
        return "qingjia/list";
    }
    @RequestMapping("/qingjia/doadd")
    public void add(Leavebill leavebill,HttpServletResponse resp){
        leavebill.setState(0);
        System.out.println("进入请假");
        int i = leavebillService.insert(leavebill);
        System.out.println("提交表单");
        resp.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter ou = resp.getWriter();
            WriteToPageUtil.printTopage(resp,"保存成功！","/qingjia/getleavebills","保存失败！","/qingjia/add.jap",i);
            System.out.println("执行完毕");
           /* if (i>0){
                ou.write("<script>alert('保存成功！');location.href='/qingjia/getleavebills'</script>");

            }else {
                ou.write("<script>alert('保存失败！');location.href='/qingjia/add.jap'</script>");

            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
