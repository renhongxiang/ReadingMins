<%-- 
    Document   : userCertifyEmail
    Created on : Oct 29, 2016, 7:05:29 PM
    Author     : renhongxiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Certify Email</title>
    </head>    
    <body>
        <c:choose>
            <c:when test="${certifyBean.certified}">
                <h1>${certifyBean.userName}, Thank you for certify your email ${certifyBean.email}. </h1>
                <a href="userLogin">Go to Login</a>
            </c:when>
            <c:otherwise>
                <h1>Email certify is failed. You can login and send certify email again.
                    Please make sure you certify your email in 30 minutes.</h1>
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
