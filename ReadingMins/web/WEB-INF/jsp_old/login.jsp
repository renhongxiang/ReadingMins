<%-- 
    Document   : login
    Created on : Sep 29, 2016, 10:11:57 PM
    Author     : renhongxiang
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Login Page</title>
        <jsp:include page="../css/body.jsp"/>
        <jsp:include page="../css/table.jsp"/>
        <jsp:include page="../css/base.jsp"/>
    </head>
    <body>
        <table class="area" style="margin-top: 200px ">
            <tr>
                <td>
                    <table class="boxcenter">
                        <tr class="textcenter">
                            <td>
                                <div class="pagehead">Sign in to Reading Log</div>
                            </td>
                        </tr>
                        <tr class="boxcenter">
                            <td>
                                <fieldset>
                                        <form:form method="post" modelAttribute="userForm" action="">
                                          <table class="textright">
                                            <tr>
                                                <td>
                                                    <table>
                                                        <tr>
                                                            <td>
                                                                <p>User ID:</p>
                                                            </td>
                                                            <td>
                                                                <form:input path="userName" type="text" /> <!-- bind to user.name-->
                                                                <form:errors path="userName" />
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <p>Password:</p>
                                                            </td>
                                                            <td>
                                                                <form:password path="password" /> <!-- bind to user.name-->
                                                                <form:errors path="password" />
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>
                                            <tr class="textcenter">
                                                <td>
                                                    <button type="submit" class="btn-lg btn-primary pull-right">Login</button>                                    
                                                </td>
                                            </tr>
                                        </table>
                                    </form:form>
                                </fieldset>
                            </td>
                        </tr>
                        <tr class="textcenter">
                            <td>
                                <a href="SignUp">Sign up</a>
                            </td>
                        </tr>
                    </table>
                    
                </td>
            </tr>
        </table>
    </body>
</html>



