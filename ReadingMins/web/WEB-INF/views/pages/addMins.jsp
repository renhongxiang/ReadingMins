<%-- 
    Document   : addMins
    Created on : Oct 18, 2016, 1:42:25 AM
    Author     : renhongxiang
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <link rel="stylesheet" href="<c:url value="/resource/css/jquery-ui.min.css" />"></link>
  <script src="<c:url value="/resource/js/jquery-3.1.1.min.js" />"></script>
  <script src="<c:url value="/resource/js/jquery-ui.min.js" />"></script>
    <table class="area">
        <tr>
            <td>
                <table class="boxcenter">
                    <tr class="textcenter">
                        <td>
                            <div class="pagehead">Enter Reading Log</div>
                        </td>
                    </tr>                    
                    <tr>
                        <td>
                            <form:form method="post" modelAttribute="minsForm" action="">
                                <table class="textright">
                                    <tr>
                                        <td>
                                            <form:label path="date">Date:</form:label>
                                        </td>
                                        <td>
                                            <form:input path="date"/><form:errors path="date" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:label path="title"> Title </form:label>
                                        </td>
                                        <td>
                                            <form:input path="title" /><form:errors path="title" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <form:label path="mins"> Reading Minutes </form:label>
                                        </td>
                                        <td>
                                            <form:input path="mins" /><form:errors path="mins" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        </td>
                                        <td>
                                            <button type="submit">Save</button>                
                                        </td>
                                    </tr>
                                </table>
                            </form:form>
                        </td>
                    </tr>
                </table>                
            </td>
        </tr>
    </table>

  <script>
  $( function() {
    $( "#date" ).datepicker({
        changeMonth: true,
        changeYear: true
    });
  } );
  </script>
