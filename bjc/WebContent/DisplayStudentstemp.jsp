<%@ page import="bjc.student.StudentDetailsBean" %>
<%@ page import="java.util.*" %>
<html>
<title>BJC Inventory Success
</title>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
 <img src="BJCHeader.GIF" alt="Mountain View" style="width:1304px;height:228px">

</head>

<%
ArrayList students =  (ArrayList) request.getAttribute("students");

System.out.println("Itmes Size" + students.size());
StudentDetailsBean bean =  null;

//System.out.println("itemNames" + items.getItemNames());

%>
<form>
<table border=15>
<tr>
<th>
Section
</th>
<th>
StudentName
</th>
<th>
SchoolName
</th>
<th>
FatherName
</th>
<th>
Occupation
</th>
<th>
Joined
</th>

<th>
ContactNumber
</th>
<th>
DoorNumber
</th>
<th>
Village
</th>
<th>
City
</th>
<th>
District
</th>

</tr>
<tr>
<% for(int i=0 ; i < students.size() ;i++)  {
	
	bean =  (StudentDetailsBean)students.get(i);
%>
<td>
<%=bean.getSection() %>

</td>
<td>
<%=bean.getStudentName() %>
</td>

<td>
<%=bean.getSchoolName() %>
</td>

<td>
<%=bean.getFatherName() %>
</td>

<td>
<%=bean.getOccupation() %>
</td>

<td>
<%=bean.getJoined() %>
</td>

<td>
<%=bean.getContactNumber() %>
</td>

<td>
<%=bean.getDoorNumber() %>
</td>

<td>
<%=bean.getVillage() %>
</td>

<td>
<%=bean.getCity() %>
</td>

<td>
<%=bean.getDistrict() %>
</td>

</tr>
<%
}
%>


</table>
</form>   
</html>