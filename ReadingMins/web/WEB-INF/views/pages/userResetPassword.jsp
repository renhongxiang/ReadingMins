<%-- 
    Document   : userResetPassword
    Created on : Nov 3, 2016, 8:46:45 AM
    Author     : renhongxiang
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="resetpassword">
    <table class="area">
        <tr>
            <td>
                <table class="boxcenter">
                    <tr class="textcenter">
                        <td>
                            <div class="pagehead">Reset Your Password</div>
                        </td>
                    </tr>
                    <form:form method="post" modelAttribute="resetPassword" action="">
                    <tr>
                        <td>
                            <table>
                                <tr>
                                    <td>
                                        <form:label path="password1" cssClass="textright">
                                                Create a password:
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:password path="password1" /> <!-- bind to user.name-->
                                    </td>
                                    <td>
                                        <form:errors path="password1" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="password2" cssClass="textright">
                                                Confirm password:
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:password path="password2"/> <!-- bind to user.name-->
                                    </td>
                                    <td>
                                        <form:errors path="password2" />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr class="textcenter">
                        <td>
                            <button type="submit" name="resetPwd">Reset Password</button>
                        </td>
                    </tr>
                    </form:form>
                </table>                
            </td>
        </tr>
    </table>        
</div>
