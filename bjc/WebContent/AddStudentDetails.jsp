<%@ include file="BJCHeader.jsp" %>
<html>
<title>Student Details
</title>

<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<script>


function validLogin() 

{ 
	var a = document.addstudent.contactNumber.value;  
	if(document.addstudent.studentName.value == "")
	{
		alert("Please enter the StudentName");
		return false;
	} else if(document.addstudent.fatherName.value == "")
	{
		alert("Please enter the FatherName");
		return false;
	}
	else if(a=="") {
		alert("please Enter the Contact Number");
		return false;
	} else if(isNaN(a))
		{
		alert("Enter the valid Mobile Number(Like : 9566137117)");
		return false;
		} else if((a.length < 1) || (a.length > 10))
		{
		alert(" Your Mobile Number must be 1 to 10 Integers");
		return false;
		}

	else if(document.addstudent.village.value == "")
	{
		alert("Please enter the Village");
		return false;
	}
		
	else{
		document.addstudent.action= "StudentInfoServlet" ;
		document.addstudent.submit();
	}
	
}
</script>
</head>
<body>
<%
String section = (String) session.getAttribute("section");
System.out.println("String value " +section);
%>
</body>

<form name=addstudent method=post>

<table>
<tr>
<td colspan="2">
<h3> Personal Information </h3>
</td>
</tr>

<tr>

<td>
Section:
</td>
<%
if (section.equals("10")) { 
%>
<td>
<select name="section">
<option value="10">2015-10th</option>
</td>
<%
} else {
%>
<td>
<select name="section">
<option value="JE1">2014-JE1</option>
<option value="JE2">2014-JE2</option>
<option value="JE3">2014-JE3</option>
<option value="JE4">2014-JE4</option>
<option value="JE5">2014-JE5</option>
<option value="JE6">2014-JE6</option>
<option value="JE7">2014-JE7</option>
<option value="JE8">2014-JE8</option>
</select>
</td>
<%
}
%>

</tr>

<tr>
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
<option value="Chaitanya Bharathi">Chaitanya Bharathi</option>
<option value="Z.P.P">Z.P.P</option>
<option value="SriChaitanya">SriChaitanya</option>
<option value="Gautham">Gautham</option>
<option value="Vivekananda">Vivekananda</option>
<option value="others">Others</option>
</select>
</td>
</tr>
<tr>
<td>
Father Name :
</td>
<td>
<input type="text" name = fatherName />
</td>
</tr>

<tr>
<td>
Occupation :
</td>
<td>
<input type="text" name = occupation />
</td>
</tr>
<tr>

<tr>
<td>
Joined Through :
</td>
<td>
<input type="text" name = joined />
</td>
</tr>
<tr>


<td colspan="2">
<h3> Address Information </h3>
</td>
</tr>

<tr>
<td>
Contact Number :
</td>
<td>
<input type="text" name = contactNumber />
</td>
</tr>
<tr>
<td>
Door Number :
</td>
<td>
<input type="text" name = doorNumber />
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
<td>
City :
</td>
<td>
<input type="text" name = city />
</td>
</tr>

<tr>
<td>
District :
</td>
<td>
<input type="text" name = district />
</td>
</tr>

<%
if (section.equals("10")) { 
%>

<tr>
<td colspan="2">
<h3> College Information </h3>
</td>
</tr>
<tr>

<td>
Remarks :
</td>
<td>
<textarea rows="4" cols="50"  name = remarks />Specify whether the student known to us and good prospect etc</textarea>
</td>
</tr>
<tr>
<td>
Following By :
</td>
<td>
<select name="staffName">
<option value="VSN">VSN</option>
<option value="MR">MR</option>
<option value="Nagi Reddy">Nagi Reddy</option>
<option value="ASR">ASR</option>
<option value="Siva">Siva</option>
<option value="others">Others</option>
</select>
</td>
</tr>
<tr>
<td>
Application Written :
</td>
<td>
<select name="application">
<option value="No">NO</option>
<option value="Yes">YES</option>
</select>
</td>
</tr>
<% 
} 

%>

<tr>
<td colspan=2 align = center>
<a class="pure-button pure-button-primary" href="#" onclick="validLogin()">Add</a>
</td>


</td>
</tr>
</table>

</form>