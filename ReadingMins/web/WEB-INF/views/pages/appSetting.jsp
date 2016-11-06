<%-- 
    Document   : setting
    Created on : Oct 15, 2016, 11:41:09 PM
    Author     : renhongxiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Setting</title>
</head>
  
<body>
    <p>Setting</p>
    <c:if test="${!Setting.emailCertified}">
        <form:form method="post" action="" >
            <input type="submit" value ="Certify Email" />
        </form:form>
    </c:if>
</body>
</html>