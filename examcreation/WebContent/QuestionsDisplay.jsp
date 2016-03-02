<%@page import="java.util.ArrayList"%>
<%@ include file="AdityaHeader.jsp" %>
<%@page import="com.aditya.exam.QuestionBean"%>
<html>
<title> Question Paper Form </title>
<body>

<link rel="stylesheet" type="text/css" href="Style.css">
<script type="text/javascript">


function createExamPaper() {

	
	var papername = document.questionDisplayForm.paperName.value;
	if(papername.length < 1){
		  alert ("Please select Question Paper Name  ");
	}
	
    var cboxes = document.getElementsByName('add');
    var len = cboxes.length;
    var temp =0;

    for (var i=0; i<len; i++) {

        if (cboxes[i].checked == true)  {

            temp=1;
        }
    }

    if(temp==0){
        alert ("Please select question ");
    } else {
    	
    	document.questionDisplayForm.action = "CreateExamPaper";
    	document.questionDisplayForm.submit();
    }

}

function addRegistraion() {
	document.registrationForm.action = "addRegistrationForm.jsp"
	document.registrationForm.submit();
}
</script>


<%
ArrayList<QuestionBean> records = (ArrayList<QuestionBean>) session.getAttribute("records");

%>

<form name = "questionDisplayForm" method= "Post"  action = "CreateQuestionPaper.jsp" onsubmit="onSubmit()" >



<table>
<tr>
<td colspan=2>
Question Paper Name :
</td> 
<td >
<input type = text name = paperName required >
</td>
	<td>
	Subject : 
    </td>
	<td>
	<input type = text name = subject value = <%=request.getParameter("subject") %> readonly> 
    </td>
</tr>
<tr>
	<td>
	Branch : 
    </td>
	<td>
	<input type = text name = branch value = <%=request.getParameter("branch") %> readonly> 
    </td>

	<td>
	Year : 
    </td>
	<td>
		<input type = text name = year value = <%=request.getParameter("year") %> readonly> 
	
   </td>
 </tr>
<tr>
	<td>
	Type of Exam : 
    </td>
	<td>
			<input type = text name = type value = <%=request.getParameter("type") %> readonly> 
	
    </td>

	<td>
	Semester : 
    </td>
	<td>
			<input type = text name = semester value = <%=request.getParameter("semester") %> readonly> 
	
    </td>
 </tr>
  </table>
<table>

<tr>
<th>
    Question
</th>

<th>
    Answer
</th>

<th>
    Add
</th>
</tr>
<tr>

<tr>
 <%
for (int i=0 ; i<records.size();i++) {
	
	QuestionBean questionBean = (QuestionBean)records.get(i);
 %>
 		            <tr>
		                <td><%=questionBean.getQuestion()%></td>
		                <td><%=questionBean.getAnswer()%></td>
		                <td>
		                <input type = checkbox name = add value = "<%=questionBean.getId()%>" >
		                </td>			                		                		                
		            </tr> 	            
<%
}
%>
<tr>
    <td colspan=1>
    <input type= "submit" value = "Add" class="button-0" >
    </td>

      <td colspan=1 >
        <input type = "Reset" class="button-0" > 
        
    </td>
        <td colspan=2 align="center">
        <input type = "button" value = "Add" class="button-0" onclick="createExamPaper()"> 
        
    </td>
</tr>


</table>
</form>
</body>
</html>
