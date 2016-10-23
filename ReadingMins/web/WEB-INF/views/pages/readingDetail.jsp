<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<c:url value="/resource/css/jquery-ui.min.css" />"></link>
<script src="<c:url value="/resource/js/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="/resource/js/jquery-ui.min.js" />"></script>
<table class="area">
    <tr>
        <td>
            <table class="boxcenter" style="width: 80%">
                <tr class="textcenter">
                    <td>
                        <div class="pagehead">Reading Log Info</div>
                    </td>
                </tr>                    
                <form:form id="formId" method="post" action="" modelAttribute="monthReadingLog">
                    <tr>
                        <td class="textcenter">
                            <label for="month">Month: </label> <input type="text" id="month" name="month" class="monthPicker" value="${month}"/>
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
                            </table>
                        </td>
                    </tr>
                </form:form>
                <form:form id="editRecForm" method="post" action="" modelAttribute="editMinsForm">
                    <tr>
                        <td>
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
                                        <button type="submit" name="saveRec">Save</button>                
                                    </td>
                                    <td>
                                        <button type="submit" name="delete">Delete</button>                
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </form:form>                    
            </table>                
        </td>
    </tr>
</table>
<script type="text/javascript">
    $(function () {
        $("#date").datepicker({
        });
    });

    $(function () {
        $(".monthPicker").datepicker({
            dateFormat: 'mm/yy',
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            onClose: function (dateText, inst) {
                $(this).datepicker('setDate', new Date(inst.selectedYear, inst.selectedMonth, 1));
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
