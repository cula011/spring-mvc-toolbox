<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="org.cula011.spring.mvc.constants.ViewConstants"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sandpit Form</title>
	    <script src="/spring-mvc-toolbox/js/jquery-1.7.1.js"></script>
	    <script type="text/javascript">
		    function doAjaxPost() {
			    // get the form values
			    var name = $('#name').val();
			    var education = $('#education').val();
			
			    $.ajax({
				    type: "POST",
				    url: "<%= ViewConstants.VIEW_SANDPIT_LINK %>",
				    data: "name=" + name + "&education=" + education,
				    success: function(response){
					    // we have the response
					    $('#info').html(response);
					    $('#name').val('');
					    $('#education').val('');
				    },
				    error: function(e){
				    	alert('Error: ' + e);
				    }
			    });
		    }
	    </script>	
	</head>
	<body>
		<h2>Basic Spring MVC Form</h2>
		<form:form action="<%= ViewConstants.VIEW_SANDPIT_LINK %>" method="post" commandName="sandpitFormData">
			<c:forEach var="sandpitData" items="${sandpitFormData.sandpitDataSet}" varStatus="count">
				<table>
					<tr>
						<td><form:checkbox path="sandpitDataSet[${count.index}].directDebit"></form:checkbox></td>
						<td>Account Name: <c:out value="${sandpitData.accountName}"/> <form:hidden path="sandpitDataSet[${count.index}].accountName"/> </td>
						<td>Account ID: <c:out value="${sandpitData.accountId}"/> <form:hidden path="sandpitDataSet[${count.index}].accountId"/></td>
					</tr>			
				</table>
			</c:forEach>
			<input type="submit" value="Submit"/>
		</form:form>
		
		<h2>Ajax Spring MVC Form</h2>
	    <table>
	    	<tr>
	    		<td>Enter your name : </td>
	    		<td> <input type="text" id="name"></td>
	   		</tr>
	        <tr>
	        	<td>Education : </td>
	        	<td> <input type="text" id="education"></td>
	       	</tr>
	        <tr>
	        	<td colspan="2"><input type="button" value="Add Users" onclick="doAjaxPost()"></td>
	       	</tr>
	        <tr>
	        	<td colspan="2"><div id="info" style="color: green;"></div></td>
	       	</tr>
	    </table>	
	</body>
</html>