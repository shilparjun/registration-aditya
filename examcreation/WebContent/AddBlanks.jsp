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
	Group : 
    </td>
    <td>
    	<select name = "group" >
    	  <option value="ECE"> ECE </option>
    	  <option value="ECE"> MECHANICAL </option>
    	  <option value="ECE"> ELECTRICAL </option>
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
    	<select name = "subject" >
    	  <option value="Subject1"> Subject1 </option>
    	  <option value="Subject2"> Subject2 </option>
    	  <option value="Subject3"> Subject3 </option>
    	  <option value="Subject4"> Subject4 </option>
    	</select>
    </td>
</tr>

<tr>
	<td>
	Chapter : 
    </td>
    <td>
    	<select name = "chapter" >
    	  <option value="chapter1"> chapter1 </option>
    	  <option value="chapter2"> chapter2 </option>
    	</select>
    </td>
</tr>

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
    	  <option value="One"> 1 </option>
    	  <option value="Two"> 2 </option>
    	</select>
    </td>
</tr>

<tr>
	<td>
	Question : 
    </td>
    <td>
    	<input type = "text" name = "question"  required>
    	<input type = "hidden" name = "type" value="Blanks">
    	
    </td>
</tr>
<tr>
	<td>
	Answer : 
    </td>
    <td>
    	<input type="text"  name = "answer" required>
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
