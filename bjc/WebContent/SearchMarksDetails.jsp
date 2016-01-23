<%@ page import="bjc.student.MarksBean" %>
<%@ page import="java.util.*" %>
<%@ include file="BJCHeader.jsp" %>


<html>
<title>Student Search Screen
</title>

<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet" type="text/css"  href="pure-min.css">

</head>
<body>

</body>
<form name = student method=post action = StudentMarksServlet>

<%
ArrayList students =  (ArrayList) request.getAttribute("student");

MarksBean bean =  null;

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

<td colspan=4 align = center>
<input type = submit  class="pure-button pure-button-primary"  > 

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


<table border=15>
<tr>
<th>
Section
</th>
<th>
FirstName
</th>
<th>
English
</th>
<th>
Maths1
</th>
<th>
Maths2
</th>
<th>
Physics
</th>
<th>
Chemistry
</th>
<th>
Total
</th>

</tr>
<tr>
<% for(int i=0 ; i < students.size() ;i++)  {
	
	bean =  (MarksBean)students.get(i);

%>
<td>
<%=bean.getSection() %>
</td>
<td>

 <a href ="StudentEditServlet?studentId=<%= bean.getStudentid() %>">   <%=bean.getFirstname()%> </a> 
</td>

<td>
<%=bean.getEnglish()%>
</td>
<td>
<%=bean.getMaths1a()%>
</td>

<td>
<%=bean.getMaths1b() %>
</td>
<td>
<%=bean.getPhysics() %>
</td>

<td>
<%=bean.getChemistry()%>
</td>

<td>
<%=bean.getTotal()%>
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