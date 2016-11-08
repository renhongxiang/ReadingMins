<%-- 
    Document   : settingPassword
    Created on : Nov 6, 2016, 7:11:23 PM
    Author     : renhongxiang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<table class="area">
    <tr>
        <td>
            <table class="boxcenter">
                <form:form method="post" modelAttribute="changeEmail" action="">
                    <tr class="textcenter">
                        <td>
                            <div class="pagehead">Email</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fieldset>
                                <table>
                                    <tr>
                                        <td>
                                            ${changeEmail.curEmail}
                                        </td>
                                        <td>
                                            <c:if test="${!changeEmail.emailCertified}">
                                                <button type="submit" name="certifyEmail">Certify Email</button>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <c:if test="${changeEmail.emailSent}">
                                                <div>Certification email has been sent.</div>
                                            </c:if>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:input path="newEmail" type="text" size="80" /> <!-- bind to user.name-->
                                        </td>
                                        <td>
                                            <button type="submit" name="saveEmail">Change Email</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:errors path="newEmail" />
                                        </td>
                                        <td>
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
