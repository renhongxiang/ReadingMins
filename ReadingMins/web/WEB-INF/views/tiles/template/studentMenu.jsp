<%-- 
    Document   : baseMenu
    Created on : Oct 15, 2016, 10:23:33 PM
    Author     : renhongxiang
--%>

<table>
    <tr>
        <td>
            <table>
                <tr>
                    <td>
                        <div>${studentName}</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>${curMonth} : read ${curmins} minutes</div>
                    </td>
                </tr>
                
            </table>
            
            
        </td>
    </tr>
    <tr>
        <td>
            <nav>
                <ul id="menu" style="background-color: lightgrey">
                   <li><a href="${pageContext.request.contextPath}/monthInfo">Download Reading Log</a></li>
                   <li><a href="${pageContext.request.contextPath}/detail">Edit Reading Log</a></li>
                   <li><a href="${pageContext.request.contextPath}/addRecord">New Reading Log</a></li>
                   <li><a href="${pageContext.request.contextPath}/selectStudent">Select Student</a></li>
                   <li><a href="${pageContext.request.contextPath}/editStudent">Edit Student</a></li>
                   <li><a href="${pageContext.request.contextPath}/addStudent">Add Student</a></li>
                </ul>
            </nav>            
        </td>
    </tr>
    
</table>
