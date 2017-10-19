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
                <ul id="menu" style="background-color: lightcyan">
                   <li><a href="${pageContext.request.contextPath}/readingLogDownload">Download Reading Log</a></li>
                   <li><a href="${pageContext.request.contextPath}/readingLogAdd">New Reading Log</a></li>
                   <li><a href="${pageContext.request.contextPath}/studentSelect">Select Student</a></li>
                   <li><a href="${pageContext.request.contextPath}/studentEdit">Edit Student</a></li>
                   <li><a href="${pageContext.request.contextPath}/studentAdd">Add Student</a></li>
                </ul>
            </nav>            
        </td>
    </tr>
    
</table>
