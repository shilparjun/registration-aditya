<html>
<title> Registration Form </title>
<body>

<link rel="stylesheet" type="text/css" href="Style.css">

<script type="text/javascript">


function onSubmit() {
var firstName = document.registrationForm.firstName.value;
    var lastName = document.registrationForm.lastName.value;
    var fatherName = document.registrationForm.fatherName.value;
    var address = document.registrationForm.address.value;
    var contact = document.registrationForm.contact.value;
    var email = document.registrationForm.email.value;

    if(firstName == "" ) {
        alert ("Please enter first name");
        return false;
    } else if(lastName == "" ) {
        alert ("Please enter last name");
        return false;
    } else if(fatherName == "" ) {
        alert ("Please enter Father name");
        return false;
    } else if(address == "" ) {
        alert ("Please enter Address");
        return false;
    } else if(contact == "" ) {
        alert ("Please enter contact");
        return false;
    } else if(email == "" ) {
        alert ("Please enter email");
        return false;
    } else {

        registrationForm.action = "AddRegistrationServlet";
    }
  
}

</script>
<form name = "registrationForm" method= "Post" onsubmit="onSubmit()" >

<table>

<tr>
	<td>
	Group : 
    </td>
    <td>
    	<select name = "group" >
    	  <option value="ECE"> ECE </option>
    	  <option value="CSC"> CSC </option>
    	  <option value="CIVIL"> CIVIL </option>
    	</select>
    </td>
</tr>

<tr>
	<td>
	Year : 
    </td>
    <td>
    	<select name = "year" >
    	  <option value="1"> 1st Year </option>
    	  <option value="2"> 2nd Year </option>
    	  <option value="3"> 3rd Year </option>
    	  <option value="4"> 4th Year </option>
    	</select>
    </td>
</tr>

<tr>
	<td>
	First Name : 
    </td>
    <td>
    	<input type = "text" name = "firstName" >
    </td>
</tr>

<tr>
	<td>
	Last Name : 
    </td>
    <td>
    	<input type = "text" name = "lastName" >
    </td>
</tr>

<tr>
	<td>
	Father Name : 
    </td>
    <td>
    	<input type = "text" name = "fatherName" >
    </td>
</tr>


<tr>
	<td>
	Address : 
    </td>
    <td>
    	<Textarea rows="4" cols="50" name = "address" >
    		Enter address
    	</textarea>
    </td>
</tr>


<tr>
	<td>
	Contact : 
    </td>
    <td>
    	<input type = "text" name = "contact" >
    </td>
</tr>

<tr>
	<td>
	Email : 
    </td>
    <td>
    	<input type = "text" name = "email" >
    </td>
</tr>


<tr>
	<td>
	Gender : 
    </td>
    <td>
    	<input type = "radio" name = "gender" value ="Male" >Male
    	<input type = "radio" name = "gender" value = "Female">Female
    </td>
</tr>

<tr>
	<td>
	Hobbies : 
    </td>
    <td>
    	<input type = "checkbox" name = "hobbie" value = "Singing">Singing
    	<input type = "checkbox" name = "hobbie" value = "Reading">Reading
    </td>
</tr>

<tr>
    <td>
    <!--	<a href="#" class="button-0" onclick="myFunction()">Submit</a> -->
    <input type= submit class="button-0" >
    </td>
    <td>
    	<input type = "Reset" class="button-0" > 
    	
    </td>
</tr>

</table>
</form>
</body>
</html>
