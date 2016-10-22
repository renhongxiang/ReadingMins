<%-- 
    Document   : addStudent
    Created on : Oct 7, 2016, 10:16:08 PM
    Author     : renhongxiang
--%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <h1>Add New Student</h1>
        <form:form method="post" modelAttribute="addStudentForm" action="">
            <table>
                <tr>
                    <td>
                        <p>First Name:</p>
                    </td>
                    <td>
                        <form:input path="firstName" type="text" /> <!-- bind to user.name-->
                        <form:errors path="firstName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Last Name:</p>
                    </td>
                    <td>
                        <form:input path="lastName" /> <!-- bind to user.name-->
                        <form:errors path="lastName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Student ID</p>
                    </td>
                    <td>
                        <form:input path="studentID" /> <!-- bind to user.name-->
                        <form:errors path="studentID" />
                    </td>
                </tr>
            </table>
                    <br>
            <button type="submit" class="btn-lg btn-primary pull-right">Save
                             </button>
        </form:form>
    </body>
</html>
