<%@ include file="AdityaHeader.jsp" %>
<script src="jquery-1.12.1.js" type="text/javascript"></script>

<html>
<title> Multiple Choice Question </title>
<body>
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
        
$('#subject').change(function(event) {
    var subject = $("select#subject").val();
    $.get('AddDescriptive', {
            branchName : subject
    }, function(response) {

    var select = $('#chapter');
    select.find('option').remove();
      $.each(response, function(index, value) {
      $('<option>').val(value).text(value).appendTo(select);
  });
    });
    });        
        
      
        
});
</script>
<link rel="stylesheet" type="text/css" href="Style.css">


<form name = "addMCQForm" method= "Post" action = "GetQuestions" >

<table>

<tr>
	<td>
	Type of Exam : 
    </td>
    <td>
    	<select name = "type" >
    	  <option value="MCQ"> MCQ </option>
    	  <option value="Descriptive"> Descriptive </option>
    	  <option value="Blanks"> Fill in the Blanks </option>
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
	Group : 
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
	<td>
	Semester : 
    </td>
    <td>
  		<select name="semester">
  		 <option>Select Semester</option>
      	  <option value="1"> 1 </option>
    	  <option value="2"> 2 </option>
    	</select>
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
