<%@page import="bjc.inventory.InventoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="BJCHeader.jsp" %>
<html>
<title>BJC Display
</title>

<head>
</head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet" type="text/css"  href="pure-min.css">

<script>  

function submitAdd() {
	document.inventory.action="AddInventory.jsp"
	document.inventory.submit();
	
}


</script> 

<form name = inventory method="post" action="InventoryDisplayServlet">
<table>
<tr>
<td>
Inventory Name:
</td>
<td>
<select name="itemNames">
<option value="College">College</option>
<option value="Girls Hostel">Girls Hostel</option>
<option value="Boys Hostel">Boys Hostel</option>
<option value="Mess">Mess</option>
<option value="Stationary">Stationary</option>
<option value="All">All</option>
</select>
</td>
</tr>
<tr>
<td>
Start Date :
<input type = Date name = startDate required> 
</td>
<td>
End Date :
<input name = endDate type = Date required >
</td>
</tr> 
<tr>

<td  align = center>

<input type=submit class="pure-button pure-button-primary" value=Search>

</td>
<td  align = center>

<a class="pure-button pure-button-primary" href="#" onclick="submitAdd()">Add</a>
</td>

</tr>
</table>
</form>
</html>