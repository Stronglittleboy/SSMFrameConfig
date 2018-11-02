<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv=content-type content="text/html; charset=utf-8" />
        <link href="css/admin.css" type="text/css" rel="stylesheet" />
        <script src="Script/jquery-1.8.0.min.js"></script>
        <script>
            $(function () {
                setInterval(getDate,1000);
            });
            function getDate() {
                var today = new Date();
                var date = today.getFullYear() + "-" + twoDigits(today.getMonth() + 1) + "-" + twoDigits(today.getDate()) + " ";
                var week = " 星期" + "日一二三四五六 ".charAt(today.getDay());
                var time = twoDigits(today.getHours()) + ": " + twoDigits(today.getMinutes()) + ": " + twoDigits(today.getSeconds());
                $(".DateTime").html("当前时间： "+date +" "+time);
            }
            function twoDigits(val) {
                if (val < 10) return "0" + val; return val;
            }
        </script>
    </head>

    <body>
        <table cellspacing=0 cellpadding=0 width="100%" align=center border=0>
            <tr height=28>
                <td background=./img/title_bg1.jpg>当前位置: </td></tr>
            <tr>
                <td bgcolor=#b1ceef height=1></td></tr>
            <tr height=20>
                <td background=./img/shadow_bg.jpg></td></tr></table>
        <table cellspacing=0 cellpadding=0 width="90%" align=center border=0>
            <tr height=100>
                <td align=middle width=100>
					<img height=100 src="./img/admin_p.gif"  width=90>
				</td>
                <td width=60>&nbsp;</td>
                <td>
                    <table height=100 cellspacing=0 cellpadding=0 width="100%" border=0>
                        <tr>
                            <td style="font-weight: bold; font-size: 16px">${userbean.userName}</td>
						</tr>
                        <tr>
                            <td class="DateTime"></td>
                        </tr>
                        <tr>
                            <td>欢迎进入网站管理中心！</td></tr></table></td>
						</tr>
            <tr>
         <td colspan=3 height=10></td></tr></table>
        <table cellspacing=0 cellpadding=0 width="95%" align=center border=0>
            <tr height=20>
                <td></td></tr>
            <tr height=22>
                <td style="padding-left: 20px; font-weight: bold; color: #ffffff" 
                    align=middle background=./img/title_bg2.jpg>个人信息</td></tr>
            <tr bgcolor=#ecf4fc height=12>
                <td></td></tr>
            <tr height=20>
                <td></td></tr></table>
        <table cellspacing=0 cellpadding=2 width="95%" align=center border=0>
            <tr>
                <td align=right width=100>登陆帐号：</td>
                <td style="color: #880000">${userbean.userName}</td></tr>
            <tr>
                <td align=right>真实姓名：</td>
                <td style="color: #880000">${userbean.userRealname}</td></tr>
            <tr>
                <td align=right>注册时间：</td>
                <td style="color: #880000"><fmt:formatDate value="${userbean.regdate}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td></tr>
            <tr>
                <td align=right>登陆次数：</td>
                <td style="color: #880000">${userbean.logincount}</td></tr>
            <tr>
                <td align=right>上线时间：</td>
                <td style="color: #880000"><fmt:formatDate value="${logintime}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td></tr>
                <td align="right"><a href="/lou">点击测试</a></td>
           
        </table>		
<div style="text-align:center;">
<p>维护信息：<a href="http://www.zparkedu.com" target="_blank">湖南管理学院</a></p>
<p>联系电话：<a href="http://www.zparkedu.com" target="_blank">17110771077</a></p>
</div>
    </body>
</html>