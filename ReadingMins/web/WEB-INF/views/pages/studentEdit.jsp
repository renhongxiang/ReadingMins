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
                    <form:form method="post" modelAttribute="editStudentForm" action="">
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
                            </table>
                        </td>
                    </tr>
                    <tr class="textcenter">
                        <td>
                            <button type="submit" name="Save">Save</button>
                            <button type="submit" name="Delete">Delete</button>
                        </td>
                    </tr>
                    </form:form>
                </table>                
            </td>
        </tr>
    </table>

