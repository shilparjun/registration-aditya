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


function validLogin(submit) 

  {

		if(submit == "edit") 
			{
				alert(submit);
				document.addstudent.action= "StudentEditServlet" ;
				//document.addstudent.submit();
			 } else if(submit == "fees"){
				alert(submit);
				document.addstudent.action= "StudentFeesServlet" ;
				//document.addstudent.submit();
             } else if(submit == "marks") {
         			alert(submit);
					document.addstudent.action= "StudentMarksServlet" ;
					//document.addstudent.submit();
             }
	}
	

</script>
</head>
<body>
<%
StudentsBean student = (StudentsBean) request.getAttribute("students");
student.toString();
%>
</body>

<form name=updatestudent method=post action=StudentsUpdateServlet>

<table>
<tr>
<td colspan="2">
<h3> Student Information </h3>
</td>

<td colspan="2">
<h3> Personal Information </h3>
</td>
</tr>

<input type = hidden name = studentid value = <%= student.getSno() %> >


<tr>

<td>
Section:
</td>
<td>
<input type = text name = section value = <%=student.getSection() %> >
</td>
<td>
Father Name :
</td>
<td>
<input type = text name = fatherName value = <%=student.getFatherName() %> >
</td>

</tr>

<tr>
<td>
First Name:
</td>
<td>
<input type = text name = firstName value = <%=student.getFirstName() %> >
</td>
<td>
Contact Number :
</td>
<td>
<input type = "tel" pattern="[0-9]{10,10}" maxlength="10" name = contactNumber value = <%=student.getContactNumber() %> >
</td>
</tr>
<tr>
<td>
Last Name:
</td>
<td>
<input type = text name = lastName value = <%=student.getLastName() %>>

</td>

<td>
Address :
</td>
<td>
<input type = text name = address value = <%=student.getAddress() %> >
</td>
</tr>


<tr>
<td>
Group :
</td>
<td>
<input type = text name = group value = <%=student.getGroup() %> >
</td>


<td>
Town/Village :
</td>
<td>
<input type = text name = town value = <%=student.getTown() %> >
</td>
</tr>
<tr>
<td>
Hostel :
</td>
<td>
<input type = text name = hostel value = <%=student.getHostel() %> >
</td>
<td>
Second Contact Number :
</td>
<td>
<input type = "tel" name = secondaryNumber value = <%=student.getSecondaryNumber() %> >
</td>
</tr>

<tr>
<td>
10th School :
</td>
<td>
<input type = text name = schoolStudied value = <%=student.getSchoolStudied() %> >
</td>
<td>
Father Occupation :
</td>
<td>
<input type = text name = fatherOccupation value = <%=student.getFatherOccupation() %> >
</td>
</tr>
<tr>
<td>
10th Grade :
</td>
<td>
<input type = text name = schoolGrade value = <%=student.getSchoolGrade()%> >
</td>
<td>
Tution Fees :
</td>
<td>
<input type = number name = schoolFees value = <%=student.getStudentFees()%> min=<%=student.getStudentFees()%> >
</td>
</tr>
</table>
<table>
<tr>
<td colspan=4 align = center>

<input type=submit class="pure-button pure-button-primary"  value= Edit > 
</td>

</tr>
</table>
</form>
