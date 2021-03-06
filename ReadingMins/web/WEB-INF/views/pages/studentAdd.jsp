<%-- 
    Document   : addStudent
    Created on : Oct 17, 2016, 8:35:11 AM
    Author     : renhongxiang
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <table class="area">
        <tr>
            <td>
                <table class="boxcenter">
                    <tr class="textcenter">
                        <td>
                            <div class="pagehead">Add New Student</div>
                        </td>
                    </tr>
                </table>
                    
                <fieldset>
                <table class="boxcenter">
                    <form:form method="post" modelAttribute="addStudentForm" action="">
                    <tr>
                        <td>
                            <table>
                                <tr>
                                    <td>
                                        <p>First Name:</p>
                                    </td>
                                    <td>
                                        <form:input path="firstName" type="text" /> <!-- bind to user.name-->
                                        <form:errors path="firstName" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <p>Last Name:</p>
                                    </td>
                                    <td>
                                        <form:input path="lastName" /> <!-- bind to user.name-->
                                        <form:errors path="lastName" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <p>Student ID</p>
                                    </td>
                                    <td>
                                        <form:input path="studentID" /> <!-- bind to user.name-->
                                        <form:errors path="studentID" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <p>Daily Target Minutes</p>
                                    </td>
                                    <td>
                                        <form:input path="dailyMins" /> <!-- bind to user.name-->
                                        <form:errors path="dailyMins" />
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr class="textcenter">
                        <td>
                            <button type="submit" class="btn-lg btn-primary pull-right">Save</button>
                        </td>
                    </tr>
                    </form:form>
                </table>                
                </fieldset>
            </td>
        </tr>
    </table>

