<%@page import="java.util.ArrayList"%>
<%@ include file="AdityaHeader.jsp" %>
<%@page import="com.aditya.exam.QuestionBean"%>
<html>
<title> Question Paper Form </title>
<body>

<link rel="stylesheet" type="text/css" href="Style.css">


<%
ArrayList<QuestionBean> records = (ArrayList<QuestionBean>) session.getAttribute("records");

%>

<form name = "questionDisplayForm" method= "Post"  action = "CreateQuestionPaper.jsp" onsubmit="onSubmit()" >



<table>

<tr>
<th>
    SNO
</th>
<th>
    Branch
</th>
<th>
    Subject
</th>
<th>
    Semester
</th>
<th>
    Question
</th>

<th>
    Answer
</th>

</tr>
<tr>

<tr>
 <%
for (int i=0 ; i<records.size();i++) {
	
	QuestionBean questionBean = (QuestionBean)records.get(i);
 %>
 		            <tr>
 		            	<td><%=i%></td>
 		            	<td><%=questionBean.getBranch()%></td>
 		            	<td><%=questionBean.getSubject()%></td>
 		            	<td><%=questionBean.getSemester()%></td>
		                <td><%=questionBean.getQuestion()%></td>
		                <td><%=questionBean.getAnswer()%></td>
		            </tr> 	            
<%
}
%>



</table>
</form>
</body>
</html>
