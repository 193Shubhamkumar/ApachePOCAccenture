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

	<%
		String hostIp = request.getParameter("host");
		String port = request.getParameter("port");
		String queueName = request.getParameter("queue");
		int queuecount = Integer.parseInt( request.getParameter("queuecount"));
		
		// it should take ip like this 65.19.151.250 
		int count = 0;
	
		
		
		String url = "tcp://" + hostIp + ":" + port;
		
		//for (int i = 0; i < 1000; i++) {
		//	for (int i = 0 ; i < queuecount; i++) {
				// create object of the class
				App m1 = new App(url, queueName, queuecount);
				Thread t1 = new Thread(m1);
				App.endLoop = false;
				t1.start();
			 // System.out.print("Thread started " + t1.getId());
		
			/* count++;
			if (count == 100000) {
				break;
				
			
			    
			} */
	%>

</body>
</html>