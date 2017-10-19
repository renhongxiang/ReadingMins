<%-- 
    Document   : selectStudent
    Created on : Oct 18, 2016, 7:21:03 AM
    Author     : renhongxiang
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

     <table class="area">
        <tr>
            <td>
                <table class="boxcenter">
                    <tr class="textcenter">
                        <td>
                            <div class="pagehead">Select a Student</div>
                        </td>
                    </tr>
                </table>
                <fieldset>
                <form:form method="post" action="" modelAttribute="studentList">
                    <table class="boxcenter">
                        <tr>
                            <td>
                                <table>
                                    <tr>
                                        <th> First Name</th>
                                        <th> Last Name</th>
                                    </tr>
                                    <c:forEach var = "student" items = "${studentList.students}">
                                        <tr>                                            
                                            <td>
                                                <input type="submit" name="firstName${student.orderID}" value="${student.firstName}" style="background:none; border-width:0px; color:blue; text-decoration:underline;" />
                                            </td>
                                            <td>
                                                <input type="submit" name="lastName${student.orderID}" value="${student.lastName}" style="background:none; border-width:0px; color:blue; text-decoration:underline;"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>                            
                            </td>
                        </tr>
                    </table>                
                </form:form>
                </fieldset>
                    
            </td>
        </tr>
    </table>

 
 