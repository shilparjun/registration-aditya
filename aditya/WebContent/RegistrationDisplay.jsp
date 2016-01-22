<%@page import="com.aditya.bean.RegistrationBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title> Registration Form </title>
<body>

<link rel="stylesheet" type="text/css" href="Style.css">
<script type="text/javascript">


function deleteFunction() {

    var cboxes = document.getElementsByName('regDelete');
    var len = cboxes.length;
    var temp =0;

    for (var i=0; i<len; i++) {

        if (cboxes[i].checked == true)  {

            temp=1;
        }
    }

    if(temp==0){
        alert ("Please select item to delete");
    }
}

function addRegistraion() {
	document.registrationForm.action = "addRegistrationForm.jsp"
	document.registrationForm.submit();
}
</script>

<form name = "registrationDisplayForm" method= "Post"  action = "AddRegistrationForm.jsp" onsubmit="onSubmit()" >

<table>

<tr>
<th>
    First Name
</th>
<th>
    Last Name
</th>
<th>
    Father Name
</th>

<th>
    Contact
</th>
<th>
    Address
</th>
<th>
    Mail
</th>
<th>
    Hobbie
</th>
<th>
    Gender
</th>
<th>
    Group
</th>
<th>
    Year
</th>
<th>
    Delete
</th>
</tr>
<tr>

<tr>
<c:forEach var="registration" items="${records}">
		            <tr>
		                <td><a href = "ViewRegistrationServlet?id= ${registration.id}" >${registration.firstName} </a></td>
		                <td>${registration.lastName}</td>
		                <td>${registration.fatherName}</td>
		                <td>${registration.contact}</td>
		                <td>${registration.address}</td>
		                <td>${registration.email}</td>
		                <td>${registration.hobbies}</td>
		                <td>${registration.gender}</td>
		                <td>${registration.group}</td>
		                <td>${registration.year}</td>
		                <td>
		                <input type = checkbox name = delete value = "${registration.id}" >
		                </td>			                		                		                
		            </tr>
</c:forEach>

</tr>

<tr>
    <td colspan=4>
    <!--    <a href="#" class="button-0" onclick="addRegistraion()">Submit</a> -->
    <input type= "submit" value = "Add" class="button-0" >
    </td>

      <td colspan=4 >
        <input type = "Reset" class="button-0" > 
        
    </td>
        <td colspan=3 align="center">
        <input type = "button" value = "Delete" class="button-0" onclick="deleteFunction()"> 
        
    </td>
</tr>


</table>
</form>
</body>
</html>
