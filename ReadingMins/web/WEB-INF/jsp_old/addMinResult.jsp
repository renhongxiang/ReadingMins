<%-- 
    Document   : addMinResult
    Created on : Oct 9, 2016, 5:18:01 PM
    Author     : renhongxiang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reading Log saved </h1>        
        <table>
            <tr>
                <td>
                    Date: 
                </td>
                <td>
                    ${rm_Date}
                </td>
            </tr>
            <tr>
                <td>
                    Title
                </td>
                <td>
                    ${rm_Title}
                </td>
            </tr>
            <tr>
                <td>
                    Reading Minutes
                </td>
                <td>
                    ${rm_Mins}
                </td>
            </tr>
            <tr>
                <td>
                    Total reading minutes for ${curMonth}
                </td>
                <td>
                    ${curmins}
                </td>
            </tr>
        </table>
        
        <a href="submitmins"> add new record</a>
        
    </body>
</html>
