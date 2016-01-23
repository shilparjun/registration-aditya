<%@ page import="bjc.inventory.InventoryBean" %>
<%@ page import="java.util.*" %>
<%@ include file="BJCHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>BJC Inventory Success
</title>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet" type="text/css"  href="pure-min.css">
</head>
<script >  

function submitAdd() {
	document.success.action="AddInventory.jsp"
	document.success.submit();
	
}

</script>

<form name=success method=post action=InventoryDisplayServlet>
<table>
<tr>
<td>
Inventory Name:
</td>
<td>
<select name="itemNames">
<option value="College" ${param.itemNames == 'College' ? 'selected' : ''}>College</option>
<option value="GirlsHostel" ${param.itemNames == 'GirlsHostel' ? 'selected' : ''}>Girls Hostel</option>
<option value="BoysHostel" ${param.itemNames == 'BoysHostel' ? 'selected' : ''}>Boys Hostel</option>
<option value="Mess" ${param.itemNames == 'Mess' ? 'selected' : ''}>Mess</option>
<option value="Stationary" ${param.itemNames == 'Mess' ? 'selected' : ''}>Stationary</option>
<option value="All" ${param.itemNames == 'All' ? 'selected' : ''}>All</option>
</select>
</td>
</tr>
<tr>
<td>
Start Date :
<input type = Date name = startDate value= ${param.startDate } required> 
</td>
<td>
End Date :
<input name = endDate type = Date value= ${param.endDate } required >
</td>
</tr> 
</table>



<table>
<tr>
<th>
Type
</th>
<th>
Name
</th>
<th>
Quantity
</th>
<th>
Cost
</th>
<th>
Date Purchased
</th>
<th>
PurchasedBy
</th>
<th>
Remarks
</th>
</tr>
<tr>

<c:forEach var="item" items="${inventory}">
		            <tr>
		                <td>${item.type}</td>
		                <td>${item.name}</td>
		                <td>${item.itemQuantity}</td>
		                <td>${item.itemCost}</td>
		                <td>${item.itemPurDate}</td>
		                <td>${item.purchasedBy}</td>
		                <td>${item.remarks}</td>
		            </tr>
</c:forEach>


<tr>
<td colspan = 4 align = "center">
<input type=submit class="pure-button pure-button-primary" value=Search>
</td>
<td colspan = 3 align = "center">
<a class="pure-button pure-button-primary" href="#" onclick="submitAdd()">Add</a>
</td>
</tr>

</table>
</form>   
</html>