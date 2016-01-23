<%@ page import="bjc.student.StudentsBean" %>
<%@ page import="java.util.*" %>
<%@ include file="BJCHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	document.student.action="StudentSearchServlet?form=fees"
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
<option value="JE3" ${param.section == 'JE3' ? 'selected' : ''}>JE3</option>
<option value="JE4" ${param.section == 'JE4' ? 'selected' : ''}>JE4</option>
<option value="JE5" ${param.section == 'JE5' ? 'selected' : ''}>JE5</option>
<option value="JE6" ${param.section == 'JE6' ? 'selected' : ''}>JE6</option>
<option value="JE7" ${param.section == 'JE7' ? 'selected' : ''}>JE7</option>
</select>
</td>
<td>
First Name:
</td>
<td> 
<input type=text name=firstName value= ${param.firstName }>
</td>
</tr>
<tr>
<td>
College Fee Confirmed:
</td>
<td>
<input type=radio name=feeConfimred value = "" ${param.feeConfimred == '' ? 'checked' : ''} checked /> All
<input type=radio name=feeConfimred value = "Yes"  ${param.feeConfimred == 'Yes' ? 'checked' : ''}/> yes
<input type=radio name=feeConfimred value = "Not Set" ${param.feeConfimred == 'Not Set' ? 'checked' : ''}/> No
<input type=radio name=feeConfimred value = "Free"  ${param.feeConfimred == 'Free' ? 'checked' : ''}/> Free

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
Student Fees Paid
</th>
<th>
Bus Fees
</th>
<th>
Bus Fees Paid
</th>
<th>
Fees Confirmed
</th>
<th>
Hostel/Bus
</th>

</tr>

<c:forEach var="fees" items="${studentsfee}">
 <tr>
        <td>${fees.section}</td>
        <td><a href ="StudentEditServlet?studentId=${fees.sno}&submit=fees">  ${fees.firstName}</a> </td>
        <td>${fees.studentFees}</td>
        <td>${fees.tutionFeePaid}</td>
        <td>${fees.busFees}</td>
        <td>${fees.busFeePaid}</td>
        <td>${fees.feesSet}</td>
        <td>${fees.hostel}</td>
 </tr>
</c:forEach>

 
</table>
</form>