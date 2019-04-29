<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>


	<%@ page import="Demo.App"%>
	<%@ page import="Demo.ConsumerApp"%>
	<%

	  String stopWhat = request.getParameter("stopWhat");
	  if("Consumer".equals(stopWhat))   
	    App.endLoop = true;
	  
	  else if("Producer".equals(stopWhat))
	   ConsumerApp.endloop = true;
	  
	  else if("Both".equals(stopWhat))
	  {
	   App.endLoop = true;
	   ConsumerApp.endloop = true;
	  }
	  
	 %>


</body>
</html>