<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="BJCHeader.jsp" %>
<%@ page import="bjc.student.StudentsBean" %>
<%@ page import="bjc.student.FeesBean" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Student Details
</title>

<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet" type="text/css"  href="pure-min.css">
<script>

</script>
</head>
<body>
<%
StudentsBean student = (StudentsBean) request.getAttribute("students");
FeesBean feeBean = null;
ArrayList feeList = (ArrayList)student.getFeeList();
student.toString();
%>
</body>

<form name=addfees method=post>

<table>
<tr>

<td>
Section:
</td>
<td>
<%=student.getSection() %>
</td>
<td>
Father Name :
</td>
<td>
<%=student.getFatherName() %>
</td>

</tr>

<tr>
<td>
First Name:
</td>
<td>
<%=student.getFirstName() %>
</td>
<td>

Hostel :
</td>
<td>
<%=student.getHostel() %>

</td>
</tr>

<tr>
<td>
AnnualFee
</td>
<td>
<%=student.getStudentFees() %>
</td>

<td>
BusFee
</td>
<td>
<%=student.getBusFees() %>
</td>
</tr>
<tr>
<td>
AnnualFee Balance
</td>
<td>
<%=student.getBalance() %> 
</td>

<td>
Bus Fee Balance
</td>
<td>
<%=student.getBusFeeBalance() %>
</td>
</tr>

</table>

<c:forEach var="fees" items="${feeList}">
		            <tr>
		                <td>${fees.annualFeesPaid}</td>
		            </tr>
</c:forEach>


<%
for (int i=0 ; i < feeList.size() ; i++) {
	
	 feeBean = (FeesBean) feeList.get(i);
	 Date date = null; 
	 Date date1 = null;
	 String dateGiven = null;
	 String nextInstallment = null;

   	 SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
     SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
     try {
    	 if(feeBean.getDateGiven() !=null) {    	 
	        date = format1.parse(feeBean.getDateGiven());
	        dateGiven = format2.format(date);
    	 }  
    	 if (feeBean.getNextInstallment()!= null) {
	        date1 = format1.parse(feeBean.getNextInstallment());
	         nextInstallment = format2.format(date1);	        
	        }
     }
	        catch ( Exception ex ){
	            System.out.println(ex);
	        }

%>

<table>
<h2> <%=i+1 %> Installment Tution and Bus Fee Detailed Summary </h1>
<tr>
<td>
FeePaid
</td>
<td>
<%=feeBean.getAnnualFeesPaid() %>
</td>

<td>
BusFeePaid
</td>
<td>
<%=feeBean.getBusfeesPaid() %>
</td>
</tr>

<tr>
<td>
Next Installment
</td>
<td>
<%=nextInstallment %>
</td>
<td>
Paid Date
</td>
<td>
<%=dateGiven %>
</td>
</tr>
<tr>
<td>
 Paid By
</td>
<td>
<%=feeBean.getPaidBy() %>
</td>
<td>
 Paid To
</td>
<td>
<%=feeBean.getGivento() %>
</td>
</tr>

</table>
<%
}
%>
<table>
<tr>

<td  align = center>
<a class="pure-button pure-button-primary" href ="StudentEditServlet?studentId=<%= student.getSno() %>&submit=feeedit"> Edit </a>

</td>

</tr>
</table>
</form>
