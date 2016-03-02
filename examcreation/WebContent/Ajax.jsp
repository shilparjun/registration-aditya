<html>
<head>
<title>AJAX in Servlet using JQuery and JSON</title>
<script src="jquery-1.12.1.js" type="text/javascript"></script>

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

    var select = $('#topic');
    select.find('option').remove();
      $.each(response, function(index, value) {
      $('<option>').val(value).text(value).appendTo(select);
  });
    });
    });        
        
        
});
</script>
</head>
<body>
<h3>AJAX in Servlet using JQuery and JSON</h3>
        Select Favorite Sports:
        <select id="branch">
                <option>Select Sports</option>
                <option value="ECE">ECE</option>
                <option value="Civil">Civil</option>
        </select>
        <br /> <br /> 
        Select Favorite Player:
        <select id="subject">
                <option>Select Player</option>
        </select>
        
        Select Topic:
        <select id="topic">
                <option>Select Player</option>
        </select>        
</body>
</html>