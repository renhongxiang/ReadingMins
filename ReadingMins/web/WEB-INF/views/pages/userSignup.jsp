<%-- 
    Document   : singup
    Created on : Oct 16, 2016, 9:06:15 AM
    Author     : renhongxiang
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

        <table class="area">
            <tr>
                <td>
                    <table class="boxcenter" style="margin-top: 200px ">
                        <tr class="textcenter">
                            <td>
                                <div class="pagehead">Create your Reading Log Account</div>
                            </td>
                        </tr>
                        <tr class="boxcenter">
                            <td>
                                <fieldset>
                                    <form:form method="post" modelAttribute="signOnForm" action="">
                                        <table class="textright">
                                            <tr>
                                                <td>
                                                    <form:label path="userName" cssClass="textright" > 
                                                            Choose your username:
                                                    </form:label>
                                                </td>
                                                <td>
                                                    <form:input path="userName" />
                                                </td>
                                                <td>
                                                    <form:errors path="userName" cssClass="error" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <form:label path="password" cssClass="textright">
                                                            Create a password:
                                                    </form:label>
                                                </td>
                                                <td>
                                                    <form:password path="password" />
                                                </td>
                                                <td>
                                                    <form:errors path="password" cssClass="error" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <form:label path="passwordConfirm" cssClass="textright">
                                                            Confirm password:
                                                    </form:label>
                                                </td>
                                                <td>
                                                    <form:password path="passwordConfirm" />
                                                </td>
                                                <td>
                                                    <form:errors path="passwordConfirm" cssClass="error" />
                                                </td>                                                
                                            </tr>
                                            <tr>
                                                <td>
                                                    <form:label path="registeremail" cssClass="textright">
                                                            Your email address:
                                                    </form:label>
                                                </td>
                                                <td>
                                                    <form:input path="registeremail" />
                                                </td>
                                                <td>
                                                    <form:errors path="registeremail" cssClass="error" />
                                                </td>
                                            </tr>
                                            <tr class="textcenter">
                                                <td>
                                                </td>
                                                <td>
                                                    <button type="submit" >Submit</button>                
                                                </td>
                                            </tr>
                                        </table>
                                    </form:form>
                                </fieldset>
                            </td>
                        </tr>
                        <tr class="center">
                            <td>
                                <a href="userLogin">sign in with exist account</a>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>