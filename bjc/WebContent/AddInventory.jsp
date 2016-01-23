<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.text.DateFormat"%>
<%@ include file="BJCHeader.jsp" %>

<%@page import="java.util.Date"%>


<html>
<title>BJC Inventory Management
</title>

<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">

<link rel="stylesheet" type="text/css"  href="pure-min.css">
</head>	

<body>

</body>

<%

Date today = new Date();

DateFormat defaultDateFormate = DateFormat.getDateInstance();
%>
<form  method="post" action="InventoryServelet">
<table>
<tr>
<td>
Inventory Name:
</td>
<td>
<select name="type" >
<option value="College">College</option>
<option value="Girls Hostel">Girls Hostel</option>
<option value="Boys Hostel">Boys Hostel</option>
<option value="Mess">Mess</option>
<option value="ExamFee">Exam Fees</option>
<option value="AdmissionFee">Admission Fee</option>
<option value="BooksFee">Books Fee</option>
<option value="Stationary">Stationary</option>
</select>
</td>
</tr>
<tr>
<td>
Name:
</td><td>
<input type="text" name="name" required>
</td>
</tr>
<tr>
<td>
Quantity :
</td><td>
<input type="number" name="quantity" required>
</td>
</tr>
<tr>
<td>
Cost :
</td> 
<td>
<input type="number" name="cost" required>
</td>
</tr>
<tr>
<td>
Purchase Date : 
</td>
<td>
<input type="Date" name="purDate" required>
</td>
</tr>
<tr>
<td>
Purchased By :
</td>
<td>
<input type="Text" name="purchasedBy" required>
</td>
</tr>
<tr>
<td>
Vendor Name :
</td>
<td>
<input type="Text" name="vendorName" required>
</td>
</tr>

<tr>
<td>
Enter By :
</td>
<td>
<input type="Text" name="enterBy" required>
</td>
</tr>

<tr>
<td>
Money Given :
</td>
<td>
<input type="radio" name="moneyGiven" value="Yes" checked >Yes
<input type="radio" name="moneyGiven" value="No" >No
</td>
</tr>

<tr>
<td>
Remarks : 
</td>
<td>
<textarea name="itemRemarks" rows="3" cols="35" required>
2 paper bundles
</textarea>
</td>
</tr>

</table>
<table>
<tr>
<td align=center>
<input type="submit" class="pure-button pure-button-primary" name=submit value="Submit"/> 
</td>
<td align=center>
<input type="reset" class="pure-button pure-button-primary" name="Reset"> 
</td>
</tr>
</table>
</form>
</html>