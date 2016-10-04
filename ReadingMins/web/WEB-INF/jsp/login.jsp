<%-- 
    Document   : login
    Created on : Sep 29, 2016, 10:11:57 PM
    Author     : renhongxiang
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <p>Sign in</p>
        <form:form method="post" modelAttribute="userForm" action="">
            
            <table>
                <tr>
                    <td>
                        <p>User ID:</p>
                    </td>
                    <td>
                        <form:input path="userID" type="text" /> <!-- bind to user.name-->
                        <form:errors path="userID" />
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
                <tr>
                    <td>
                        <p>Confirm Password:</p>
                    </td>
                    <td>
                        <form:password path="passwordconfirm" /> <!-- bind to user.name-->
                        <form:errors path="passwordconfirm" />
                    </td>
                </tr>
                
            </table>
                    <br>
            <button type="submit" class="btn-lg btn-primary pull-right">Login
                             </button>
        </form:form>
        
    </body>
</html>



