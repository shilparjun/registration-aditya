<%@ page import="bjc.student.StudentsBean" %>
<%@ page import="java.util.*" %>
<%@ include file="BJCHeader.jsp" %>


<html>
<title>Student Search Screen
</title>

<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet" type="text/css"  href="pure-min.css">

<script>
function submitAdd() {
	document.student.action="AddStudentDetails.jsp"
	document.student.submit();
	
	}
	
function submitSearch() {
	document.student.action="StudentSearchServlet"
	document.student.submit();
	
	}
	
function editRecord(var1) {
	alert(var1);
	document.student.action="StudentEditServlet?studentId=10";
	document.student.submit();
	
	}
	
	

</script>

</head>
<body>

</body>
<form name = student method=post>

<%
ArrayList students =  (ArrayList) request.getAttribute("students");

StudentsBean bean =  null;

%>

<table>
<tr>
<td>
Section:
</td>
<td>
<select name="section">
<option value="">All</option>
<option value="JE1" ${param.section == 'JE1' ? 'selected' : ''}>JE1</option>
<option value="JE2" ${param.section == 'JE2' ? 'selected' : ''}>JE2</option>
<option value="JE1" ${param.section == 'JE3' ? 'selected' : ''}>JE3</option>
<option value="JE2" ${param.section == 'JE4' ? 'selected' : ''}>JE4</option>
<option value="JE1" ${param.section == 'JE5' ? 'selected' : ''}>JE5</option>
<option value="JE2" ${param.section == 'JE6' ? 'selected' : ''}>JE6</option>
<option value="JE1" ${param.section == 'JE7' ? 'selected' : ''}>JE7</option>
</select>
</td>
<td>
First Name:
</td>
<td>
<input type=text name=firstName />
</td>
</tr>
<tr>
<td>
College Fee Confirmed:
</td>
<td>
<input type=radio name=feeConfimred value = "Yes" /> yes
<input type=radio name=feeConfimred value = "Not Set" /> No
<input type=radio name=feeConfimred value = "Free"  /> Free
<input type=radio name=feeConfimred value = "" checked /> All
</td>
</td>

<td>
Father Name :
</td>
<td>
<input type="text" name = fatherName />
</td>
</tr>
<tr>
<td>
Town :
</td>
<td>
<input type="text" name = town />
</td>
<td>
Hostel :
</td>
<td>
<input type="radio" name = "hostel" value= "Hoste"  /> YES
<input type="radio" name = "hostel" value= "" checked /> NO
</td>
</tr>
<tr>

<td colspan=3 align = center>
<a class="pure-button pure-button-primary" href="#" onclick="submitSearch()">Search</a> 

</td>
<td colspan=3 align = center>
<a class="pure-button pure-button-primary" href="#" onclick="submitAdd()">Add</a>
</td>

</tr>
</table>

<% 
if (students == null )  {
} else if(students.size() == 0) {
%>

No Records found
<%	
} else { 
%>


<table>
<tr>
<th>
Section
</th>
<th>
FirstName
</th>
<th>
Student Fees
</th>
<th>
Father Name
</th>
<th>
School Studied</th>
<th>
10th Grade
</th>
<th>
Town
</th>
<th>
Hostel/Bus
</th>

</tr>
<tr>
<% for(int i=0 ; i < students.size() ;i++)  {
	
	bean =  (StudentsBean)students.get(i);

%>
<td>
<%=bean.getSection() %>
</td>
<td>

 <a href ="StudentEditServlet?studentId=<%= bean.getSno() %>&submit=edit">   <%=bean.getFirstName()%> </a> 
</td>

<td>
<%=bean.getStudentFees()%>
</td>


<td>
<%=bean.getFatherName() %>
</td>

<td>
<%=bean.getSchoolStudied()%>
</td>

<td>
<%=bean.getSchoolGrade()%>
</td>
<td>
<%=bean.getTown()%>
</td>
<td>
<%=bean.getHostel()%>
</td>

</tr>
<%
}
%>
</table>

<%
}
%>


</form>