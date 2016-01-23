<%@ include file="BJCHeader.jsp" %>
<%@ page import="bjc.student.StudentsBean" %>
<%@ page import="bjc.student.FeesBean" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<html>
<title>Student Details
</title>

<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<link rel="stylesheet" type="text/css"  href="pure-min.css">

<script>
function validateForm() {
	alert(Mallik);
    var x = document.forms["updatefees"]["TutionFees"].value;
	alert(x);
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }
}


  </script>
 </head>
<body>
 
<%
StudentsBean student = (StudentsBean) session.getAttribute("students");
FeesBean feeBean = null;
ArrayList feeList = (ArrayList)student.getFeeList();
student.toString();

DateFormat df = new SimpleDateFormat("dd/MM/yy");
String formattedDate = df.format(new Date());
%>

<form name="updatefees" method="post" onsubmit="return validateForm()" action="StudentFeeServlet" >

<table>
<tr>
<input type = hidden name =studentid value = <%=student.getSno() %> >

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
Last Name:
</td>
<td>
<%=student.getLastName() %>

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
AnnualFeePaid
</td>
<td>
<%=student.getTutionFeesPaidAmount() %>
</td>

<td>
BusFeePaid
</td>
<td>
<%=student.getBusFeesPaidAmount() %>
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

<table>
<tr>
<td>
Tution Fees : 
</td>
<td>
<input type = number name = TutionFees value= "<%= request.getParameter("TutionFees") %>" max = <%=student.getBalance() %> required> 
</td>
<tr>


<td>
Bus Fees : 
</td>
<% if (student.getBusFeeBalance() == 0) {
%>
<td>
<input type = number name = BusFees disabled max = <%=student.getBusFeeBalance() %> > 
</td>
<%
} else {
%>
<td>
<input type = number name = BusFees  value= "${param.BusFees}" max = <%=student.getBusFeeBalance() %> required> 
</td>
<%
}
%>
</tr>

<tr>
<td>
Received From : 
</td>
<td>

<input type = text name = ReceivedFrom value= "${param.ReceivedFrom}" >
 
</td>
</tr>

<tr>
<td>
Received By : 
</td>
<td>

<input type = text name = ReceivedBy value = "${param.ReceivedBy}" required> 
</td>
</tr>

<tr>
<td>
Next Payment Date : 
</td>
<td>
<input type = date  name = NextPayment value = "${param.NextPayment}" required> 
</td>
</tr>
<tr>
<td>
Remarks : 
</td>
<td>
<textarea name = remarks >${param.remarks}</textarea>
</td>
</tr>
</table>


<table>
<tr>

<td  align = center>
<input type = submit class="pure-button pure-button-primary" value = CONFIRM>    

</td>

</tr>
</table>
</form>
</body>
</html>

