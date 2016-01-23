<%@ include file="BJCHeader.jsp" %>
<%@ page import="bjc.student.StudentsBean" %>
<%@ page import="java.util.*" %>
<html>
<title>Student Details
</title>

<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet" type="text/css"  href="pure-min.css">
<script>

</script>
</head>
<body>
<%
StudentsBean student = (StudentsBean) request.getAttribute("students");
student.toString();
%>
</body>

<form name=addstudent method=post>

<table>
<tr>
<td colspan="2">
<h3> Student Information </h3>
</td>

<td colspan="2">
<h3> Personal Information </h3>
</td>
</tr>

<tr>

<td>
Section:
</td>
<td>
<%=student.getSection() %>
</td>
<td>
Father Name :
</td>
<td>
<%=student.getFatherName() %>
</td>

</tr>

<tr>
<td>
First Name:
</td>
<td>
<%=student.getFirstName() %>
</td>
<td>
Contact Number :
</td>
<td>
<%=student.getContactNumber() %>
</td>
</tr>
<tr>
<td>
Last Name:
</td>
<td>
<%=student.getLastName() %>

</td>

<td>
Address :
</td>
<td>
<%=student.getAddress() %>
</td>
</tr>


<tr>
<td>
Group :
</td>
<td>
<%=student.getGroup() %>
</td>


<td>
Town/Village :
</td>
<td>
<%=student.getTown() %>
</td>
</tr>
<tr>
<td>
Hostel :
</td>
<td>
<%=student.getHostel() %>
</td>
<td>
Second Contact Number :
</td>
<td>
<%=student.getSecondaryNumber() %>
</td>
</tr>

<tr>
<td>
10th School :
</td>
<td>
<%=student.getSchoolStudied() %>
</td>
<td>
Father Occupation :
</td>
<td>
<%=student.getFatherOccupation() %>
</td>
</tr>
<tr>
<td>
10th Grade :
</td>
<td>
<%=student.getSchoolGrade()%>
</td>
<td>
Tution Fees :
</td>
<td>
<%=student.getStudentFees()%>
</td>
</tr>
</table>
<table>
<tr>
<td colspan=1 align = center>
<a class="pure-button pure-button-primary" href ="StudentEditServlet?studentId=<%= student.getSno() %>&submit=fees"> Fees </a>
</td>
<td colspan=1 align = center>
<a class="pure-button pure-button-primary" href ="StudentEditServlet?studentId=<%= student.getSno() %>&submit=marks">Marks</a>
</td>
<td colspan=2 align = center>
<a class="pure-button pure-button-primary" href ="StudentEditServlet?studentId=<%= student.getSno() %>&submit=edit"> Edit </a>

</td>

</tr>
</table>
</form>
