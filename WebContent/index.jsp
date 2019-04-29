<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body style="">
<center>
<b>CAVISSON SYSTEMS</b> 
<br>
<form action="process.jsp" method="get">
Host:
<input type="text" name="host" id="host">
<br>
Port:
<input type="text" name="port" id="port">
<br>
Queue Name:
<input type="text" name="queue" id="queue">
<br>
<select name="serviceType" id="serviceType">
<option value="wsTypeDoc">SEND A MESSAGE TO QUEUE</option>

</select>
<br>
<br>
Message Count:
<input type="text" name="queuecount" id="queuecount">
<br>
<br>
<select name ="stopWhat" id="stopWhat">
<br>
<br>
<option value="Consumer">StartConsumer</option>
<option value="Producer">StartProducer</option>
<option value="Both">StartBoth</option>
 <br>
 <br>
 
</select>
<input type="submit" value="Submit">
</form>
</center>
<a href="Test.jsp"> Call to Consumer </a>
</body>

</html>