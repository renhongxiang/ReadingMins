<%-- 
    Document   : settingPassword
    Created on : Nov 6, 2016, 7:11:23 PM
    Author     : renhongxiang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="resetpassword">
    <table class="area">
        <tr>
            <td>
                <table class="boxcenter">
                    <tr class="textcenter">
                        <td>
                            <div class="pagehead">Change Password</div>
                        </td>
                    </tr>
                    <form:form method="post" modelAttribute="changePassword" action="">
                    <tr>
                        <td>
                            <fieldset>
                                <table>
                                    <tr>
                                        <td>
                                            <form:label path="oldPassword" cssClass="textright">
                                                Old Password:
                                            </form:label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:password path="oldPassword" /> <!-- bind to user.name-->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:errors path="oldPassword" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:label path="newPassword" cssClass="textright">
                                                New Password:
                                            </form:label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:password path="newPassword" /> <!-- bind to user.name-->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:errors path="newPassword" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:label path="newPassword2" cssClass="textright">
                                                Confirm Password:
                                            </form:label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:password path="newPassword2" /> <!-- bind to user.name-->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:errors path="newPassword2" />
                                        </td>
                                    </tr>
                                    <tr class="textcenter">
                                        <td>
                                            <button type="submit" name="chnagePwd">Change Password</button>
                                        </td>
                                    </tr>
                                </table>
                            </fieldset>
                        </td>
                    </tr>
                    <tr class="textright">
                        <td>
                            <button type="submit" name="back">Back</button>
                        </td>                        
                    </tr>
                    </form:form>
                </table>                
            </td>
        </tr>
    </table>        
</div>
