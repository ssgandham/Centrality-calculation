<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="java.net.*"%>
<%@page import="java.util.Date"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.io.output.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    DiskFileItemFactory factory = new DiskFileItemFactory();
    // files smaller than 5MB will be held in memory
    factory.setSizeThreshold(5000000); 

    ServletFileUpload upload = new ServletFileUpload(factory);
    upload.setFileSizeMax(10000000); // max size of attachment 10MB

    List list = upload.parseRequest(request);
    Iterator iter = list.iterator();

    String csv = null;

    while (iter.hasNext()) {            
      FileItem param = (FileItem)iter.next();
     System.out.println( param.getInputStream());
      if (!param.isFormField()) { 
        csv = param.getString();
        break;
      }
    }

    if (csv==null) {
      throw new Exception("CSV buffer not uploaded");
    }
	%>
</body>
</html>