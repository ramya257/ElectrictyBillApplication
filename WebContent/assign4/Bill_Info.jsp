<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Information</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.billDTO!=null}">



<h3> Welcome <c:out value="${billDTO.consumerName}"></c:out></h3><br>

<h2>Electricity Bill for Consumer Number  <c:out value="${billDTO.consumerNumber}"></c:out> is:<br>
Units Consumed:: <c:out value="${billDTO.unitsConsumed }"></c:out><br>
Net Amount:: Rs.<c:out value="${billDTO.netAmount }"></c:out>
</h2>

</c:when>
<c:otherwise>

<font color="red">Error Occurred</font>
</c:otherwise>
</c:choose>

</body>
</html>
