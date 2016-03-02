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
        
$('#topic').change(function(event) {
    var topic = $("select#topic").val();
    $.get('AddDescriptive', {
            branchName : topic
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


<form name = "addMCQForm" method= "Post" action = "GetQuestionPapers" >

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

<table>
<tr>
    <td>
    <!--	<a href="#" class="button-0" onclick="myFunction()">Submit</a> -->
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
