<%-- 
    Document   : settingEmailConfirm
    Created on : Nov 7, 2016, 8:23:35 PM
    Author     : renhongxiang
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<table class="area">
    <tr>
        <td>
            <table class="boxcenter">
                <tr class="textcenter">
                    <td>
                        <div class="pagehead">Your account email has been changed. A certify email has been send to your new email account. 
                            Please certify your email account to enable retrieve user name and password.</div>
                    </td>
                </tr>
                <form:form method="post" action="">
                <tr class="textcenter">
                    <td>
                        <button type="submit">Back</button>
                    </td>
                </tr>
                </form:form>
            </table>                
        </td>
    </tr>
</table>
