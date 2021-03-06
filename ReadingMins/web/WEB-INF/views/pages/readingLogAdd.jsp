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
                <table class="boxcenter, area" >
                    <tr class="textcenter">
                        <td>
                            <div class="pagehead">Enter Reading Log</div>
                        </td>
                    </tr>
                </table>                
                <fieldset>
                <table class="boxcenter, area" >
                    <form:form id="formId" method="post" action="" modelAttribute="monthReadingLog">
                    <tr>
                        <td class="textcenter">
                            <label for="month">Month: </label> 
                            <input type="hidden" id="monthpost" name="monthpost" value="${monthhidden}" >
                            <input type="text" id="month" name="month" class="monthPicker" value="${monthReadingLog.month}"/>
                        </td>
                    </tr>                    
                    <tr class="textcenter">
                        <td>
                            <table class="boxcenter, area">
                                <tr>
                                    <th>Day</th>
                                    <th style="width: 70%">Title</th>
                                    <th>Minutes</th>
                                </tr>
                                <c:forEach var = "readLog" items = "${monthReadingLog.readLogList}">
                                    <tr>                                            
                                        <td>
                                            <input type="submit" name="monthReadingLog${readLog.id}" value="${readLog.day}" style="background:none; border-width:0px; color:blue; text-decoration:underline;" />
                                        </td>
                                        <td>
                                            ${readLog.title}
                                        </td>
                                        <td>
                                            ${readLog.mins}
                                        </td>
                                    </tr>
                                </c:forEach>
                                    <tr class="textcenter">
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <br>
                                        </td>
                                    </tr>
                                    <tr class="textcenter">
                                        <td>
                                            <c:choose>
                                                <c:when test="${monthReadingLog.short}">
                                                    <div class="error">${monthReadingLog.shortMins} minutes short</div>
                                                </c:when>
                                                <c:otherwise>
                                                    ${monthReadingLog.moreMins} minutes more
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            Total ${monthReadingLog.totalMins} Minutes
                                        </td>
                                    </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td class="boxcenter">
                            <table class="boxcenter" >
                                <tr>
                                    <td class="textright">
                                        <form:label path="date">Date:</form:label>
                                    </td>
                                    <td>
                                        <form:input path="date"/>
                                    </td>
                                    <td>
                                        <form:errors path="date" cssClass="error" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="textright">
                                        <form:label path="title"> Title: </form:label>
                                    </td>
                                    <td>
                                        <form:input path="title" size="60" />
                                    </td>
                                    <td>
                                        <form:errors path="title" cssClass="error" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="textright">
                                        <form:label path="mins"> Reading Minutes: </form:label>
                                    </td>
                                    <td>
                                        <form:input path="mins" />
                                    </td>
                                    <td>
                                        <form:errors path="mins" cssClass="error" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td>
                                        <button type="submit" name="saveNew">Save</button>                
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    </form:form>
                </table>                
                </fieldset>
            </td>
        </tr>
    </table>

<script type="text/javascript">
    $(function () {
        $("#date").datepicker();
    });

    $(function () {
        $(".monthPicker").datepicker({
            dateFormat: 'mm/yy',
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            onClose: function (dateText, inst) {
                var month = inst.selectedMonth + 1;
                var hiddendate =  month + "/" + inst.selectedYear;
                $('#monthpost').val(hiddendate);
//                $(this).datepicker('setDate', new Date(inst.selectedYear, inst.selectedMonth, 1));
                $('#formId').submit(); // <-- SUBMIT            
            },
            beforeShow: function (input, inst) {
                var datestr;
                if ((datestr = $(this).val()).length > 0) {
                    year = datestr.substring(datestr.length - 4, datestr.length);
                    month = datestr.substring(0, 2) - 1;
                    $(this).datepicker('option', 'defaultDate', new Date(year, month, 1));
                    $(this).datepicker('setDate', new Date(year, month, 1));
                }
            },
            
        });
        
        $(".monthPicker").focus(function () {
            $(".ui-datepicker-calendar").hide();
            $("#ui-datepicker-div").position({
                my: "center top",
                at: "center bottom",
                of: $(this)
            });
        });        
    });
</script>
