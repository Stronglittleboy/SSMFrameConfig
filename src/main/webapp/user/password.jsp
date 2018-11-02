<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>
    <%--会根据顺序进行加载js，所以， jq--》》validate--%>
    <script type="text/javascript" src="/Script/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="/Script/jquery.validate.js"  ></script>

    <script type="text/javascript">
            $(function(){
                $("form").validate({
                    rules:{

                        userPs:{required:true,minlength:6},
                        RenewPwd:{required:true,equalTo:"#newPwd"}
                    },
                    messages:{
                        userPs:{
                            required:"请输入新密码",
                            minlength:"新密码至少6位"
                        },
                        RenewPwd:{
                            required:"请输入重复密码",
                            equalTo:"两次密码要一致"
                        }
                    }
                })
            })
    </script>
</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：个人中心-》密码修改</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="/user/updatepassword" method="post">
    <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td align="right" width="80">原密码：</td>
            <td>
                <input type="hidden" name="userId" value="${userbean.userId}"/>
                <input type="text" name="password" value="${userbean.userPs}" readonly="readonly"/></td>
        </tr>
        <tr>
            <td align="right" width="90">新密码：</td>
            <td><input type="password" name="userPs" id="newPwd"/></td>
        </tr>
        <tr>
            <td align="right" width="90">密码确认：</td>
            <td><input type="password" name="RenewPwd" /></td>
        </tr>
       
        <tr align="center">
            <td colspan="5" height="40">
                <div align="center">
                    
                    <input type="submit" id="button2" value="确认" />
                </div>
            </td>
        </tr>
    </table>
    </form>


            </div>
        </div>
    </div>
</body>
</html>
