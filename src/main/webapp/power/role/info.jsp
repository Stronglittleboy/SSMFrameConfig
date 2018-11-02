<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
    
    
</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：权限管理-》角色管理-》详情</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="javascript:history.back();">【返回】</a>
                </span>
            </span>
        </div>
</div>
<div class="cztable">
	<form action="list.html" method="post">
<table border="1" width="100%" class="table_a">
                <tr  width="120px;">
                    <td width="120px">角色名：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="f_goods_image" value="${role.rolename}" readonly/>
					</td>
                </tr>

                <tr  width="120px;">
                    <td>菜单资源<span style="color:red">*</span>：</td>
                    <td>
                        <ul>
                            <c:forEach items="${menus}" var="menu"  varStatus="sta">
                            <li><input type="checkbox" name="menuid" checked  readonly class="top${menu.menuid}" value="${menu.menuid}" onclick="return false;"

                            />${menu.menuname}
                                <ul>

                                    <c:forEach items="${menu.menus}" var="twomenu" varStatus="cla">
                                        <li>&nbsp;&nbsp;&nbsp;&nbsp
                                            <input type="checkbox" checked readonly class="down${menu.menuid}" name="menuid" value="${twomenu.menuid}" onclick="return false;">${twomenu.menuname} </li>

                                    </c:forEach>
                                </ul>
                            </li>
                            </c:forEach>

                    </td>
                </tr>

    <tr>
        <td>启用状态<span style="color:red">*</span>：</td>
        <td>
            <c:if test="${role.rolestate==1}">
                <input type="radio" name="rolestate" checked onclick="return false;" value="1" readonly/>启用
            </c:if>
            <c:if test="${role.rolestate==0}">
                <input type="radio" name="rolestate" value="0" onclick="return false;" readonly checked/>禁用
            </c:if>

        </td>
    </tr>
				
				
			</table>
	</form>
</div>

            </div>
        </div>
        
    </div>
</body>
</html>
