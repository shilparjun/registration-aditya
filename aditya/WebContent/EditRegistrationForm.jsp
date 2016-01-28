<%@page import="java.util.*"%>
<%@page import="com.aditya.bean.RegistrationBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<title> Registration Form </title>
<body>

<link rel="stylesheet" type="text/css" href="Style.css">


<%

RegistrationBean regBean = (RegistrationBean)session.getAttribute("registration");

%>


<form name = "registrationForm" method= "Post" action= "EditRegistrationServlet" >


<table>

<tr>
	<td>
	Group : 
    </td>
    <td>
    	<select name = "group" >
    	  <option value="ECE" <%=regBean.getGroup().equals("ECE") ? "selected" : ""%>> ECE </option>
    	  <option value="CSC" <%=regBean.getGroup().equals("CSC") ? "selected" : ""%>> CSC </option>
    	  <option value="CIVIL" <%=regBean.getGroup().equals("CIVIL") ? "selected" : ""%>> CIVIL </option>
    	</select>
    </td>
</tr>

<tr>
	<td>
	Year : 
    </td>
    <td>
    	<select name = "year" >
    	  <option value="1" <%=regBean.getYear() == 1 ? "selected" : ""%>> 1st Year </option>
    	  <option value="2" <%=regBean.getYear() == 2 ? "selected" : ""%>> 2nd Year </option>
    	  <option value="3" <%=regBean.getYear() == 3 ? "selected" : ""%>> 3rd Year </option>
    	  <option value="4" <%=regBean.getYear() == 4 ? "selected" : ""%>> 4th Year </option>
    	</select>
    </td>
</tr>

<tr>
	<td>
	First Name : 
    </td>
    <td>
        <input type=hidden name = id value = <%=regBean.getId() %>>
    	<input type = "text" name = "firstName" value= <%=regBean.getFirstName() %>>
    </td>
</tr>

<tr>
	<td>
	Last Name : 
    </td>
    <td>
    	<input type = "text" name = "lastName" value= <%=regBean.getLastName() %>>
    </td>
</tr>

<tr>
	<td>
	Father Name : 
    </td>
    <td>
    	<input type = "text" name = "fatherName" value= <%=regBean.getFatherName() %>>
    </td>
</tr>


<tr>
	<td>
	Address : 
    </td>
    <td>
    	<Textarea rows="4" cols="50" name = "address">
<%=regBean.getAddress() %>
    	</textarea>
    </td>
</tr>


<tr>
	<td>
	Contact : 
    </td>
    <td>
    	<input type = "text" name = "contact" value= <%=regBean.getContact() %>>
    </td>
</tr>

<tr>
	<td>
	Email : 
    </td>
    <td>
    	<input type = "text" name = "email" value= <%=regBean.getEmail() %>>
    </td>
</tr>


<tr>
	<td>
	Gender : 
    </td>
    <td>
    	<input type = "radio" name = "gender" value ="Male" <%=regBean.getGender().equals("Male") ? "checked" : ""%> >Male
    	<input type = "radio" name = "gender" value ="Female" <%=regBean.getGender().equals("Female") ? "checked" : ""%>>Female
    </td>
</tr>

<tr>
	<td>
	Hobbies : 
    </td>
    <td>
    	<input type = "checkbox" name = "hobbie"  value = "Singing" <%=regBean.getHobbies().equals("Singing") ? "checked" : ""%>>Singing
    	<input type = "checkbox" name = "hobbie" value = "Reading" <%=regBean.getHobbies().equals("Reading") ? "checked" : ""%> >Reading
    </td>
</tr>

<tr>
    <td>
    <!--	<a href="#" class="button-0" onclick="myFunction()">Submit</a> -->
    <input type= submit class="button-0" >
    </td>
    <td>
    	<input type = "Reset" class="button-0"> 
    	
    </td>
</tr>

</table>
</form>
</body>
</html>
