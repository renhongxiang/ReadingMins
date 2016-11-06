<%-- 
    Document   : userPasswordResetRequest
    Created on : Oct 31, 2016, 8:24:21 PM
    Author     : renhongxiang
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<div id="password">
    <table class="area">
        <tr>
            <td>
                <table class="boxcenter">
                    <tr class="textcenter">
                        <td>
                            <div class="pagehead">Forgot Password</div>
                        </td>
                    </tr>
                    <form:form method="post" modelAttribute="resetPwdReq" action="">
                    <tr>
                        <td>
                            <table>
                                <tr>
                                    <td>
                                        <p>Enter your email:</p>
                                    </td>
                                    <td>
                                        <form:input path="email" type="text" size="80" /> <!-- bind to user.name-->
                                        <form:errors path="email" />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr class="textcenter">
                        <td>
                            <table class="boxcenter">
                                <tr>
                                    <td>
                                        <button type="submit" name="resetPwd">Reset Password</button>
                                    </td>
                                    <td>
                                        <button type="submit" name="cancel" class ="button" >Cancel</button>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    </form:form>
                </table>                
            </td>
        </tr>
    </table>        
</div>
    

