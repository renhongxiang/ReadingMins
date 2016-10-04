<%-- 
    Document   : signonpage
    Created on : Sep 30, 2016, 7:40:44 AM
    Author     : renhongxiang
--%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create your ReadingMins Account</h1>
        <fieldset>
            <form:form method="post" modelAttribute="signOnForm" action="">
                <table>
                    <tr>
                        <td>
                            <form:label path="userName"> 
                                    Choose your username<form:errors path="userName" cssClass="error" />
                            </form:label>
                                 
                        </td>
                        <td>
                            <form:input path="userName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">
                                    Create a password <form:errors path="password" cssClass="error" />
                            </form:label>
                        </td>
                        <td>
                            <form:password path="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="passwordConfirm">
                                    Confirm password <form:errors path="passwordConfirm" cssClass="error" />
                            </form:label>
                        </td>
                        <td>
                            <form:password path="passwordConfirm" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="registeremail">
                                    Your email address <form:errors path="registeremail" cssClass="error" />
                            </form:label>
                        </td>
                        <td>
                            <form:input path="registeremail" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            <button type="submit" class="btn-lg btn-primary pull-right">Submit
                                        </button>                
                        </td>
                    </tr>
                </table>
            </form:form>
        </fieldset>
    </body>
</html>
