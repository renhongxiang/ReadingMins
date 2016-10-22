<%-- 
    Document   : studentInfo
    Created on : Oct 7, 2016, 1:52:30 AM
    Author     : renhongxiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>info</title>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    Student Name:
                </td>
                <td>
                    ${studentName}
                </td>
            </tr>
            <tr>
                <td>
                    This month minutes:
                </td>
                <td>
                    ${curmins}
                </td>
            </tr>
            <tr>
                <td>
                    ${difftype}
                </td>
                <td>
                    ${diffmins}
                </td>
            </tr>
        </table>
    </body>
</html>
