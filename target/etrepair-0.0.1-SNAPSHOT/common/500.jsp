<%@page import="com.liveneo.etrepair.log.LVLogger"%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Exception) request.getAttribute("javax.servlet.error.exception");

	//记录日志
	LVLogger logger = LVLogger.getLogger(this.getClass());
	logger.error(ex.getMessage(), ex);
%>

<!DOCTYPE html>
<html>
<head>
<title>500 - 系统内部错误</title>
</head>

<body>
	<div><h1>系统发生内部错误.</h1></div>
</body>
</html>
