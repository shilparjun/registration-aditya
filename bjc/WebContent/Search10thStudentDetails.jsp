<%@ page import="bjc.student.StudentDetailsBean" %>
<%@ page import="java.util.*" %>
<%@ include file="BJCHeader.jsp" %>

<html>


<title>Bharathi Junior College </title>

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
</script>

</head>
<body>


</body>
<form name = student action="StudentSearchServlet" method=post>

<%
ArrayList students =  (ArrayList) request.getAttribute("students");
session.setAttribute("section", "10");
StudentDetailsBean bean =  null;

%>

<table>
<tr>
<td>
Section:
</td>
<td>
<select name="section">
<option value="10">2015-10th</option>
</select>
</td>
<td>
Student Name:
</td>
<td>
<input type=text name=studentName />
</td>
</tr>
<tr>
<td>
School Name:
</td>
<td>
<select name="schoolName">
<option value="">ALL</option>
<option value="Chaitanya Bharathi">Chaitanya Bharathi</option>
<option value="Z.P.P">Z.P.P</option>
<option value="SriChaitanya">SriChaitanya</option>
<option value="Gautham">Gautham</option>
<option value="Vivekananda">Vivekananda</option>
<option value="others">Others</option>
</select>
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
Street/Village :
</td>
<td>
<input type="text" name = village />
</td>
</tr>
<tr>
<td colspan=2 align = center>

<a class="pure-button pure-button-primary" href="#" onclick="submitSearch()">Search</a>

</td>
<td colspan=2 align = center>

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


<table border=15 class="pure-table">
<thead>
<tr>
<th>
Section
</th>
<th>
StudentName
</th>
<th>
SchoolName
</th>
<th>
FatherName
</th>
<th>
Occupation
</th>
<th>
Joined
</th>

<th>
ContactNumber
</th>
<th>
DoorNumber
</th>
<th>
Village
</th>
<th>
City
</th>
<th>
District
</th>
</tr>
 </thead>
<tr>
<% for(int i=0 ; i < students.size() ;i++)  {
	
	bean =  (StudentDetailsBean)students.get(i);
%>
<td>
<%=bean.getSection() %>

</td>
<td>
<%=bean.getStudentName() %>
</td>

<td>
<%=bean.getSchoolName() %>
</td>

<td>
<%=bean.getFatherName() %>
</td>

<td>
<%=bean.getOccupation() %>
</td>

<td>
<%=bean.getJoined() %>
</td>

<td>
<%=bean.getContactNumber() %>
</td>

<td>
<%=bean.getDoorNumber() %>
</td>

<td>
<%=bean.getVillage() %>
</td>

<td>
<%=bean.getCity() %>
</td>

<td>
<%=bean.getDistrict() %>
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