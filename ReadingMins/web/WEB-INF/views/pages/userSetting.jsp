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
    
    <table>
        <tr>
            <td>
                <%-- Change Email --%>
                <table>
                    <form:form method="post" modelAttribute="email" action="">
                        <tr>
                            <td>
                                Email:
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            ${email}
                                        </td>
                                        <td>
                                            <c:if test="${!Setting.emailCertified}">
                                                <button type="submit" name="certifyEmail">Certify Email</button>
                                            </c:if>
                                        </td>
                                        <td>
                                            <button type="submit" name="changeEmail">Change Email</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </form:form>
                </table>
            </td>
        <tr>
        <tr>
            <td>
                <%-- Change Email --%>
                <table>
                    <form:form method="post" modelAttribute="password" action="">
                        <tr>
                            <td>
                                Email:
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            ${email}
                                        </td>
                                        <td>
                                            <c:if test="${!Setting.emailCertified}">
                                                <button type="submit" name="certifyEmail">Certify Email</button>
                                            </c:if>
                                        </td>
                                        <td>
                                            <button type="submit" name="changeEmail">Change Email</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </form:form>
                </table>
            </td>
        <tr>
            
    </table>
    
</body>
</html>