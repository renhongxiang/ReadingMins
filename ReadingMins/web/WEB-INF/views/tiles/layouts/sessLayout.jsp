<%-- 
    Document   : sessLayout
    Created on : Oct 15, 2016, 10:22:12 PM
    Author     : renhongxiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page import="com.framework.utils.WebUtils" %>
<% 
    WebUtils util = WebUtils.getInstance();
    if(!util.isInSession(request)){
        response.sendRedirect("userLogin"); 
        return;
    }
%>    

<!DOCTYPE html>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>
    <tiles:insertAttribute name="css" />
</head>
<body>
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>
        
        <table class="area">
            <tr>
                <td style="width: 200px" class="top">
                    <table cellpadding ="0" cellspacing = "0" width ="100%" align = "center">
                        <tr>
                            <td>
                                <tiles:insertAttribute name="menu" />
                            </td>
                        </tr>
                    </table>                            
                </td>
                <td>
                    <table cellpadding ="0" cellspacing = "0" width ="100%" align = "center">
                        <tr>
                            <td>
                                <tiles:insertAttribute name="body" />
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>