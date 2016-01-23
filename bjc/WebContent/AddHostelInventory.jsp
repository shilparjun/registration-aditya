<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.text.DateFormat"%>
<%@ include file="BJCHeader.jsp" %>

<%@page import="java.util.Date"%>

<script type="text/javascript" >
function validLogin() 
{ 
	if(document.forms[0].itemRequired.value == "")
	{
		alert("Please enter the Item Purchased");
		return false;
	} else if(document.forms[0].itemQuantity.value == "")
	{
		alert("Please enter the Quantity");
		return false;
	}
	else if(document.forms[0].itemCost.value == "")
	{
		alert("Please enter the Cost");
		return false;
	}
	else if(document.forms[0].purchasedBy.value == "")
	{
		alert("Please enter the Purchased By");
		return false;
	}
	else if(document.forms[0].vendorName.value == "")
	{
		alert("Please enter the Vendor Name");
		return false;
	}
	else if(document.forms[0].enterBy.value == "")
	{
		alert("Please enter the Enter By");
		return false;
	}
	else if(document.forms[0].moneyGiven.value == "")
	{
		alert("Please enter the Money Given");
		return false;
	} 
	else{
		document.forms[0].submit;
	}
	
}
</script>

<html>
<title>BJC Inventory Management
</title>

<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>	

<body>

</body>

<%

Date today = new Date();

DateFormat defaultDateFormate = DateFormat.getDateInstance();
%>
<form onsubmit="return validLogin();" action="HostelInventoryServlet">
<table>

<tr>
<td>
*Item Name:
</td>
<td>
<input type="text" name="itemName">
</td>
</tr>

<td>
*Quantity :
</td><td>
<input type="text" name="itemQuantity">
</td>
</tr>
<tr>
<td>
*Cost :
</td> 
<td>
<input type="text" name="itemCost">
</td>
</tr>
<tr>
<td>
*Date Purchased : 
</td>
<td>
<input type="text" name="itemPurDate" >
</td>
</tr>
<tr>
<td>
*Purchased By :
</td>
<td>
<input type="Text" name="purchasedBy">
</td>
</tr>
<tr>
<td>
*Vendor Name :
</td>
<td>
<input type="Text" name="vendorName">
</td>
</tr>

<tr>
<td>
*Money Given :
</td>
<td>
<input type="radio" name="moneyGiven" value="Yes" checked>Yes
<input type="radio" name="moneyGiven" value="No">No
</td>
</tr>

<tr>
<td>
*Money Given Date:
</td><td>
<input type="text" name="itemRequired">
</td>
</tr>
<tr>

<tr>
<td>
Remarks : 
</td>
<td>
<textarea name="itemRemarks" rows="3" cols="35">
2 paper bundles
</textarea>
</td>
</tr>

</table>
<center>
<table>
<tr>
<td align=center>
<input type="submit" name=submit value="Submit"/> 
</td>
<td align=center>
<input type="reset" name="Reset"> 
</td>
</tr>
</table>
</center>
</form>
</html>