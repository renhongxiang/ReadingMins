<%-- 
    Document   : login.jsp
    Created on : Oct 16, 2016, 12:56:49 AM
    Author     : renhongxiang
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <table class="area" style="margin-top: 200px ">
        <tr>
            <td>
                <table class="boxcenter">
                    <tr class="textcenter">
                        <td>
                            <div class="pagehead">Sign in to Reading Log</div>
                        </td>
                    </tr>
                    <tr class="boxcenter">
                        <td>
                            <fieldset>
                                    <form:form method="post" modelAttribute="userForm" action="">
                                      <table>
                                        <tr >
                                            <td>
                                                <table class="textright">
                                                    <tr>
                                                        <td>
                                                            <form:label path="userName"> 
                                                                    User ID:
                                                            </form:label>
                                                        </td>
                                                        <td>
                                                            <form:input path="userName" type="text" /> <!-- bind to user.name-->
                                                        </td>
                                                        <td style="textleft">
                                                            <form:errors path="userName" cssClass="error" />
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <form:label path="password"> 
                                                                    Password:
                                                            </form:label>
                                                        </td>
                                                        <td>
                                                            <form:password path="password" /> <!-- bind to user.name-->
                                                        </td>
                                                        <td style="textleft">
                                                            <form:errors path="password" cssClass="error"/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr class="textcenter">
                                            <td>
                                                <button type="submit" >Login</button>                                    
                                            </td>
                                        </tr>
                                    </table>
                                </form:form>
                            </fieldset>
                        </td>
                    </tr>
                    <tr class="textcenter">
                        <td>
                            <a href="userSignup">Sign up</a>
                        </td>
                    </tr>
                </table>

            </td>
        </tr>
    </table>
