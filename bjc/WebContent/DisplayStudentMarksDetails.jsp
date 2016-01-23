<%@ include file="BJCHeader.jsp" %>
<%@ page import="bjc.student.StudentsBean" %>
<%@ page import="bjc.student.MarksBean" %>
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
MarksBean marksBean = (MarksBean)student.getMarksBean();
student.toString();
%>
</body>

<form name=addfees action="StudentMarksServlet"  method=post>

<table>
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
Last Name:
</td>
<td>
<%=student.getLastName() %>

</td>
</tr>
<tr>
<td>
Address :
</td>
<td>
<%=student.getAddress() %>
</td>

<td>
Group :
</td>
<td>
<%=student.getGroup() %>
</td>
</tr>
<tr>
<td>
Town/Village :
</td>
<td>
<%=student.getTown() %>
</td>

<td>
Hostel :
</td>
<td>
<%=student.getHostel() %>
</td>
</tr>
<tr>
<td>
Contact Number :
</td>
<td>
<%=student.getContactNumber() %>
</td>

<td>
10th School :
</td>
<td>
<%=student.getSchoolStudied() %>
</td>

</tr>
<tr>
<td>
Father Occupation :
</td>
<td>
<%=student.getFatherOccupation() %>
</td>

<td>
10th Grade :
</td>
<td>
<%=student.getSchoolGrade()%>
</td>
</tr>

<%
	
	 marksBean = (MarksBean) student.getMarksBean();

%>

<table>

<tr>
<td>
Total Marks :

</td>

<td>
<%=marksBean.getTotal() %>

</td>


<td>
Exam Type : 
</td>
<td>
<%=marksBean.getExamtype() %>
</td>
<tr>
<td>
English
</td>
<td>
<%=marksBean.getEnglish()%>
</td>
</tr>
<tr>
<td>
Sanskrit
</td>
<td>
<%=marksBean.getSanskrit() %>
</td>
</tr>
<tr>
<td>
Maths1A
</td>
<td>
<%=marksBean.getMaths1a() %>
</td>
</tr>
<tr>
<td>
 Maths1B
</td>
<td>
<%=marksBean.getMaths1b() %>
</td>
</tr>
<tr>
<td>
 Physics
</td>
<td>
<%=marksBean.getPhysics() %>
</td>
</tr>
<tr>
<td>
 Chemistry
</td>
<td>
<%=marksBean.getChemistry() %>
</td>
</tr>

</table>

<table>
<tr>
<td colspan=1 align = center>
<a class="pure-button pure-button-primary" href ="StudentEditServlet?studentId=<%= student.getSno()  %>&submit=fees"> Fees </a>
</td>
<td colspan=1 align = center>
<input class="pure-button pure-button-primary" type= submit > 
</td>
<td colspan=2 align = center>
<a class="pure-button pure-button-primary" href ="StudentEditServlet?studentId=<%= student.getSno() %>&submit=edit"> Edit </a>

</td>

</tr>
</table>
</form>
