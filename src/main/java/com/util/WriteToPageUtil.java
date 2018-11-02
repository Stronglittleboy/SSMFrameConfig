package com.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
* 向页面写入提示信息
* 参数：map（Message，url）
* 返回值:无
* */
public class WriteToPageUtil {
    public static  void printTopage(HttpServletResponse resp, String alert1,String url1,String alert2,String url2,Integer rs){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put(alert1,url1);
        map.put(alert2,url2);
        printTopage(resp,map,rs);
    }
    public static  void printTopage(HttpServletResponse resp, LinkedHashMap<String,String> map,Integer rs){
        Map map1=map;
        printTopage(resp,map1,rs);
    }
    public static  void printTopage(HttpServletResponse resp, Map<String,String > map,Integer rs) {
        resp.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter ou = resp.getWriter();
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            it.hasNext();
            if (rs > 0) {
                Map.Entry<String, String> entr = it.next();
                ou.write("<script>alert('" + entr.getKey() + "');location.href='" + entr.getValue() + "'</script>");
            } else {
                it.next();
                Map.Entry<String, String> entr = it.next();
                ou.print("<script>alert('" + entr.getKey() + "');location.href='" + entr.getValue() + "'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
