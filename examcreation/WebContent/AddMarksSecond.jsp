<%@page import="java.util.ArrayList"%>
<%@ include file="AdityaHeader.jsp" %>
<%@page import="com.aditya.exam.StudentBean"%>
<html>
<title> Question Paper Form </title>
<body>

<link rel="stylesheet" type="text/css" href="Style.css">
<script type="text/javascript">


function createExamPaper() {

    	document.addMarks.action = "AddSemesterMarks";
    	document.addMarks.submit();
    }



function addMarks() {
	document.addMarks.action = "addMarks.jsp"
	document.addMarks.submit();
}
</script>


<%
ArrayList<StudentBean> records = (ArrayList<StudentBean>) session.getAttribute("records");

%>

<form name = "addMarks" method= "Post"  action = "AddSemesterMarks" >



<table>
<tr>
	<td>
	Branch : 
    </td>
	<td>
	<input type = text name = branch value = <%=request.getParameter("branch") %> readonly> 
    </td>

	<td>
	Year : 
    </td>
	<td>
		<input type = text name = year value = <%=request.getParameter("year") %> readonly> 
	
   </td>
 </tr>
<tr>
	<td>
	Subject : 
    </td>
	<td>
	<input type = text name = subject value = <%=request.getParameter("subject") %> readonly> 
    </td>

	<td>
	Semester : 
    </td>
	<td>
	<input type = text name = semester value = <%=request.getParameter("semester") %> readonly> 
	
    </td>
 </tr>
  </table>

<table>

<tr>
<th>
    FirstName
</th>
<th>
    Last Name
</th>
<th>
    Roll Number
</th>
<th>
    1st Internal 
</th>

<th>
    2nd Internal
</th>
</tr>


 <%
for (int i=0 ; i<records.size();i++) {
	
	StudentBean studentBean = (StudentBean)records.get(i);
 %>
 		            <tr>
 		           		<td><%=studentBean.getFirstName()%></td>
		                <td><%=studentBean.getLastName()%></td>
		                <td><%=studentBean.getRollNumber()%></td>
		                <td><input type=text name = internal1<%=studentBean.getId()%> required></td>
		                <td><input type=text name = internal2<%=studentBean.getId()%> required></td>
		            </tr> 	            
<%
}
%>
<tr>


      <td colspan=3 >
        <input type = "Reset" class="button-0" > 
        
    </td>
        <td colspan=2 align="center">
        <input type = "submit" value = "Submit" class="button-0" > 
        
    </td>
</tr>


</table>
</form>
</body>
</html>
