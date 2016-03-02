<%@page import="java.util.ArrayList"%>
<%@ include file="AdityaHeader.jsp" %>
<%@page import="com.aditya.exam.QuestionBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title> Registration Form </title>
<body>

<link rel="stylesheet" type="text/css" href="Style.css">
<script type="text/javascript">


function deleteFunction() {

    var cboxes = document.getElementsByName('delete');
    var len = cboxes.length;
    var temp =0;

    for (var i=0; i<len; i++) {

        if (cboxes[i].checked == true)  {

            temp=1;
        }
    }

    if(temp==0){
        alert ("Please select item to delete");
    } else {
    	
    	document.questionPaperDisplay.action = "DeleteExamPaper";
    	document.questionPaperDisplay.submit();
    }

}

</script>


<%
ArrayList<QuestionBean> records = (ArrayList<QuestionBean>) session.getAttribute("records");

%>

<form name = "questionPaperDisplay" method= "Post"  action = "CreateQuestionPaper.jsp" onsubmit="onSubmit()" >

<table>

<tr>
<th>
    Paper Name
</th>
<th>
    Branch
</th>
<th>
    Year
</th>
<th>
    Subject
</th>

<th>
    Semester
</th>

<th>
    Delete
</th>
</tr>
<tr>

<tr>

 <%
for (int i=0 ; i<records.size();i++) {
	
	QuestionBean regBean = (QuestionBean)records.get(i);
 %>
 		            <tr>
		                <td><a href = "GetQuestionPapers?id=<%=regBean.getId()%>" ><%=regBean.getPaperName()%></td>
		                <td><%=regBean.getBranch()%></td>
		                <td><%=regBean.getYearjoined() %></td>
		                <td><%=regBean.getSubject()%></td>
		                <td><%=regBean.getSemester()%></td>
		                <td>
		                <input type = checkbox name = delete value = <%=regBean.getId()%> >
		                </td>			                		                		                
		            </tr> 	            
<%
}
%>
<tr>
    <td colspan=2>
    <input type= "submit" value = "Add" class="button-0" >
    </td>

      <td colspan=2 >
        <input type = "Reset" class="button-0" > 
        
    </td>
        <td colspan=2 align="center">
        <input type = "button" value = "Delete" class="button-0" onclick="deleteFunction()"> 
        
    </td>
</tr>


</table>
</form>
</body>
</html>
