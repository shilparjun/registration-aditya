<%@ include file="AdityaHeader.jsp" %>
<%@page import="java.util.ArrayList"%>

<%@page import="com.aditya.exam.StudentMarksBean"%>

<script src="jquery-1.12.1.js" type="text/javascript"></script>

<html>
<title> Multiple Choice Question </title>
<body>

<link rel="stylesheet" type="text/css" href="Style.css">

<%!
StudentMarksBean marks = null;
%>

<%
ArrayList<StudentMarksBean> records = (ArrayList<StudentMarksBean>) session.getAttribute("records");

marks = (StudentMarksBean)records.get(0);


%>
<form name = "addMarks" method= "Post" action = "GetSemesterMarks" >

<table>

<tr>
	<td>
	Year : 
    </td>
    <td>
<%=marks.getYear() %>    </td>
</tr>

<tr>
	<td>
	Branch : 
    </td>
    <td>
  		<%=marks.getBranch()%>
    </td>
</tr>
<tr>
	<td>
	Subject : 
    </td>
    <td>
	<%=marks.getSubject()%>    </td>
</tr>
<tr>
	<td>
	Semester : 
    </td>
    <td>
	<%=marks.getSemester()%>
    </td>
</tr>
</table>
<table>
<tr>
<th>
Name
</th>
<th>
Roll Number
</th>
<th>
Internal1 Marks
</th>
<th>
Internal2 Marks
</th>
<th>
Consolidated Marks
</th>
</tr>
<tr>
 <%
for (int i=0 ; i<records.size();i++) {
	
	StudentMarksBean marksBean = (StudentMarksBean)records.get(i);
 %>
 		            <tr>
 		           		<td><%=marksBean.getFirstname()%></td>
		                <td><%=marksBean.getRollnumber()%></td>
		                <td><%=marksBean.getMarks1()%></td>
		                <td><%=marksBean.getMarks2() %></td>
		                <td><%=marksBean.getFinalmarks()%></td>
		            </tr> 	            
<%
}
%>
<tr>
</table>
<table>
<tr>
    <td>
    <!--	<a href="#" class="button-0" onclick="myFunction()">Submit</a> -->
    <input type= submit value = Submit class="button-0" >
    </td>
    <td>
    	<input type = "Reset" class="button-0" > 
    	
    </td>
</tr>

</table>
</form>
</body>
</html>
