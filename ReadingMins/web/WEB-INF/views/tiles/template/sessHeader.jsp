<%-- 
    Document   : sessHeader
    Created on : Oct 20, 2016, 8:57:42 AM
    Author     : renhongxiang
--%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table class="area">
    <tr>
        <td style="width: 100%">
        </td>
        <td>
            <table>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/settingPassword">Setting</a>
                    </td>
                        
                    <td>                        
                        <a href="help" />Help</a>
                    </td>
                    <td>                        
                        <a href="userLogout" />Logout</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
