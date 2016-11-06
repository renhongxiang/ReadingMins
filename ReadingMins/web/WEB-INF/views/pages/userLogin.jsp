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
                        <form:form method="post" modelAttribute="userForm" action="">
                            <fieldset>
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
                                                    <td class="textleft">
                                                        <form:input path="userName" type="text" /> <!-- bind to user.name-->
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                    </td>
                                                    <td class="textleft">
                                                        <form:errors path="userName" cssClass="error" />
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <form:label path="password"> 
                                                            Password:
                                                        </form:label>
                                                    </td>
                                                    <td class="textleft">
                                                        <form:password path="password" /> <!-- bind to user.name-->
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                    </td>
                                                    <td class="textleft">
                                                        <form:errors path="password" cssClass="error"/>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr class="textcenter">
                                        <td>
                                            <button type="submit" class="button" >Login</button>                                    
                                        </td>
                                    </tr>
                                </table>
                            </fieldset>
                        </form:form>
                    </td>
                </tr>
                <tr class="textcenter">
                    <td>
                        <table class="area">
                            <tr>
                                <td class="textleft">
                                    <a href="userSignup">Sign up</a>
                                </td>
                                <td class="textright">
                                    <a href="userRetrieveUserID">Forgot UserID</a>/<a href="userRetrievePassword">Password</a>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                
            </table>
        </td>
    </tr>
</table>
