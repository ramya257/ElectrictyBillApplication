<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="/assign4/Error.jsp"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Consumer</title>
</head>
<body>


<c:choose>

<c:when test="${consumerDTO!=null}">

<table style="border: 4px solid black;">

<caption>Consumer Details</caption>

<tr>
<td> <b>Consumer Id:</b></td>
<td><c:out value="${consumerDTO.consumerNumber}"></c:out></td></tr>
<tr>
<td><b> Consumer Name: </b></td>
<td><c:out value="${consumerDTO.consumerName}"></c:out></td></tr>
<tr>
<td><b>Address: </b></td>
<td><c:out value="${consumerDTO.consumerAddress}"></c:out></td></tr>
<tr><td><a href="/JSPProjects/EBillController?reqParam=4&&consumerId=${consumerDTO.consumerNumber}">Show Bill Details</a></td></tr>

</table>

<h1><a href="/JSPProjects/assign4/index.html">HOME</a></h1>

</c:when>

<c:otherwise>

<form action="/JSPProjects/EBillController" method="get">
Enter Customer Number:<input type="text" name="consumerId"/>
<input type="hidden"  name="reqParam" value=3>
<input type="submit" value="Search"/>
</form>      
</c:otherwise> 
</c:choose>
<body>
</html>