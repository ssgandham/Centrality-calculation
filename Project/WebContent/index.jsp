<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Calculate_Centrality">
		<input type="checkbox" name="Calculate_Centrality" value="weight">
		Weight<br> <input type="input" name="input_path" /> <input
			type="submit" value="Betweeness Centrality" /><br> <br>
	</form>

	<form action="Calculate_Closeness_Centrality">
		<input type="checkbox" name="Calculate_Centrality" value="weight">
		Weight<br> <input type="input" name="input_path" /> <input
			type="submit" value="Closeness Centrality" />
	</form>
	
	<form action="Calculate_Degree_Centrality">
		<input type="checkbox" name="Calculate_Centrality" value="weight">
		Weight<br> <input type="input" name="input_path" /> <input
			type="submit" value="Degree Centrality" />
	</form>
</body>
</html>