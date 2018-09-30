<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="/assign4/Error.jsp"
    pageEncoding="ISO-8859-1" import="java.util.*"%>

     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bills Display</title>
</head>
<body>
<c:choose>
<c:when test="${ not empty requestScope.consumerBillList }">
<table style="border:4px solid black;">
<tr>
<th>Bill Number</th>
<th>Bill Month</th>
<th>Current Reading</th>
<th>Units Consumed</th>
<th>Net Amount</th>
</tr>

<c:forEach items="${consumerBillList}" var="bills">
<tr>
		<td><c:out value="${bills.billNumber}"></c:out></td>
		<td><c:out value="${bills.billDate}"></c:out></td>
		<td><c:out value="${bills.currentReading}"></c:out></td>
		<td><c:out value="${bills.unitsConsumed}"></c:out></td>
		<td><c:out value="${bills.netAmount}"></c:out></td>

</tr>
</c:forEach>

<tr><td><a href="/JSPProjects/EBillController?reqParam=5">Generate next bill</a></td></tr>
</table>
</c:when>
<c:otherwise>
 <h3><font color="red">No bill Details Found for Bill Number:<c:out value="${consumerNumber}"></c:out></font></h3>
 
<a href="/JSPProjects/EBillController?reqParam=5">Click here to generate new bill</a>
</c:otherwise>

</c:choose>
<h1><a href="/JSPProjects/assign4/index.html">Home</a></h1>
</body>
</html>