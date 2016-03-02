<%@ include file="AdityaHeader.jsp" %>
<script src="jquery-1.12.1.js" type="text/javascript"></script>


<html>
<title> Multiple Choice Question </title>
<body>

<link rel="stylesheet" type="text/css" href="Style.css">
<script>
$(document).ready(function() {

$('#branch').change(function(event) {
        var branch = $("select#branch").val();
        $.get('AddDescriptive', {
                branchName : branch
        }, function(response) {

        var select = $('#subject');
        select.find('option').remove();
          $.each(response, function(index, value) {
          $('<option>').val(value).text(value).appendTo(select);
      });
        });
        });
       
});
</script>

<form name = "addMCQForm" method= "Post" action = "MCQ" >

<table>

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
	Semester : 
    </td>
    <td>
  		<select name="semester">
  		 <option>Select Semester</option>
      	  <option value="1"> 1 </option>
    	  <option value="2"> 2 </option>
    	  <option value="3"> 3 </option>
    	  <option value="4"> 4 </option>
    	  <option value="5"> 5 </option>
    	  <option value="6"> 6 </option>
    	  <option value="7"> 7 </option>
    	  <option value="8"> 8 </option>
    	</select>
    </td>
</tr>
<tr>
	<td>
	Branch : 
    </td>
    <td>
  		<select id="branch" name="branch">
  		 <option>Select Branch</option>
      	  <option value="ECE"> ECE </option>
    	  <option value="MECHANICAL"> MECHANICAL </option>
    	  <option value="ELECTRICAL"> ELECTRICAL </option>
    	  <option value="CSC"> CSC </option>
    	  <option value="CIVIL"> CIVIL </option>
    	</select>
    </td>
</tr>

<tr>
	<td>
	Subject : 
    </td>
    <td>
        <select id="subject" name="subject">
                <option>Select Subject</option>
        </select>
    </td>
</tr>
<tr>

<tr>
	<td>
	Complexity : 
    </td>
    <td>
    	<select name = "complexity" >
    	  <option value="Simple"> Simple </option>
    	  <option value="Medium"> Medium </option>
    	  <option value="Tough"> Complex </option>
    	</select>
    </td>
</tr>


<tr>
	<td>
	Marks : 
    </td>
    <td>
    	<select name = "marks" >
    	  <option value="7">7</option>
    	  <option value="4"> 4 </option>
    	  <option value="2"> 2 </option>
    	</select>
    </td>
</tr>

<tr>
	<td>
	Question : 
    </td>
    <td>
    	<input type = "text" name = "question" size="85" required>
    	<input type = "hidden" name = "type" value="Descriptive">
    	
    </td>
</tr>
<tr>
	<td>
	Answer : 
    </td>
    <td>
    	<textarea  name = "answer" rows=5 cols="50" required>
    	</textarea>
    </td>
</tr>

</table>
<table>
<tr>
    <td>
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
