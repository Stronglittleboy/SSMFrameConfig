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
                <span style="float:left">当前位置是：权限管理-》菜单-》详情</span>
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
                    <td width="120px">资源菜单名：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="f_goods_image" value="${menu.menuname}" />
					</td>
                </tr>

				<tr  width="120px;">
                    <td>上级菜单：<span style="color:red">*</span>：</td>
                    <td>
                    	<select>
                            <c:choose>
                                <c:when test="${menu.upmenuid==-1}">
                        	<option value="0" selected disabled >顶级菜单</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="1"  selected disabled>${menu.menuname}</option>
                                </c:otherwise>
                            </c:choose>


                            
                        </select>
					</td>
                </tr>

                <tr  width="120px;">
                    <td>菜单路径<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="f_goods_image" value="${menu.menupath==null?"路径未设置":menu.menupath}"  readonly />
					</td>
                </tr>
                
                <tr>
                    <td>启用状态<span style="color:red">*</span>：</td>
                    <td>
                        <c:if test="${menu.menustate==1}">
                        <input type="radio"  name="state" checked value="1"  readonly />启用${menu.menustate}
                            </c:if>
                        <c:if test="${menu.menustate==-1}">
                            <input type="radio" name="state" value="0"
        checked readonly
        />禁用</c:if>
                    </td>
                </tr>

				
                <tr  width="120px;">
                    <td>备注<span style="color:red">*</span>：</td>
                    <td>
						<textarea rows="5" cols="20">${menu.menuremark}</textarea>
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
