<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="true"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Consumers</title>
</head>
<body ><%
if(request.getAttribute("consumersList")!=null){
%>
<table style="border:4px black solid;">
<tr>
<th> UserID</th>
<th> UserName</th>
<th> Address </th>
</tr>
<tr>
    <c:forEach items="${consumersList}" var="objectList"> 
      <tr>
        <td><c:out value="${objectList.consumerNumber}"></c:out></td>
        <td><c:out value="${objectList.consumerName}"></c:out></td>
        <td><c:out value="${objectList.consumerAddress}"></c:out></td>
        <td><a href="/JSPProjects/EBillController?reqParam=4&&consumerId=${objectList.consumerNumber}">Show Bill Details</a></td>
      </tr>
    </c:forEach>
</tr>
</table>
<% }%>
</body>
</html>