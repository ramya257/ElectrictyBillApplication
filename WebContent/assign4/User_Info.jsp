<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Bill</title>
</head>
<body>
<form action="/JSPProjects/EBillController" method="get">
Customer Number:<input type="text" name="consumerId"/><br>
Last Month Reading:<input type="text" name="previousReading"/><br>
Current Month Reading:<input type="text" name="currentReading"/><br>
<input type="hidden"  name="reqParam" value=6>
<input type="submit" value="Calculate Bill"/>
</form>      
</body>
</html>