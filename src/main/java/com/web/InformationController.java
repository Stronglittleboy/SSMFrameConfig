package com.web;

import com.bean.Classes;
import com.bean.Information;
import com.bean.Infotype;
import com.service.InformationService;
import com.service.InfotypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InformationController {
    @Autowired
    private InformationService informationService;
    @Autowired
    private InfotypeService infotypeService;
    /*添加Infomation信息*/
    @RequestMapping("/book/list-ziliao")
    public String ToAdd(ModelMap map){
        System.out.println("开始跳转");
        List<Infotype> infotype = infotypeService.findall();
        map.put("infotype",infotype);
        return "book/add";
    }
    @RequestMapping("/book/add")
    public void add(MultipartFile myfile, HttpServletRequest request, HttpServletResponse resp,Information information){
        String path=request.getRealPath("resposity");
        try {
            myfile.transferTo(new File(path+"/"+myfile.getOriginalFilename()));//复制
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.setAttribute("filename",myfile.getOriginalFilename());

        Date date = new Date();
        information.setDate(date);
        information.setPath(myfile.getOriginalFilename());
        System.out.println(information.getPath()+"====");

        resp.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter ou = resp.getWriter();
            int insert = informationService.insert(information);
            if (insert==1){
                ou.print("<script>alert('上传成功');location.href='/book/list-ziliao'</script>");
            }else {
                ou.print("<script>alert('上传失败');location.href='/book/add'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
