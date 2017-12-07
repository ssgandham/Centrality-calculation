<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Centralities of Graph</title>
</head>
<style>
/* Reference : https://www.w3schools.com/css/tryit.asp?filename=trycss_forms */
#outPopUp {
	position: absolute;
	width: 300px;
	height: 200px;
	z-index: 15;
	top: 50%;
	left: 50%;
	margin: -100px 0 0 -150px;
	background: red;
}

input[type=text] {
	width: 51%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 20%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	padding: 20px;
}

a {
	text-decoration: none;
}
/* form {
    display: inline-block;
    text-align: center;
} */
div.form {
	/*  display: block; */
	text-align: center;
}

form {
	width: 100%;
	margin-left: auto;
	margin-right: auto;
	display: inline-block;
} 
/* body {
background-image: url("https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Graph_betweenness.svg/1024px-Graph_betweenness.svg.png");
background-repeat: no-repeat;
background-attachment: fixed;
background-size: cover;
}  */
</style>

 <!-- <body background="https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Graph_betweenness.svg/1024px-Graph_betweenness.svg.png">
 -->	 
 <body> 
 	<center><h1>Popular Node using Centrality</h1></center>
	<div class="form">
		<form action="Calculate_Centrality">
			<!-- <input type="checkbox" name="Calculate_Centrality" value="weight"> -->
			<input
				type="text" name="input_path" placeholder="File Path" required /><br><br><br><br>
			<a href="https://en.wikipedia.org/wiki/Betweenness_centrality">
				What's Betweenness Centrality ???</a><br> <br> 
				 
				<input
				type="submit" value="Betweeness Centrality" /><br> <br>
		</form>
	</div>

	<div class="form">
		<form action="Calculate_Degree_Centrality">
			<!-- <input type="checkbox" name="Calculate_Centrality" value="weight"> -->
			<a href="https://en.wikipedia.org/wiki/Centrality#Degree_centrality">
				What's Degree Centrality ??? </a><br> <br> 
				<!-- <input type="text"
				name="input_path" placeholder="File Path" required />  -->
				<input
				type="submit" value="Degree Centrality" />
		</form>
	</div>
	<div class="form">
		<form action="Calculate_Closeness_Centrality">
			<!-- <input type="checkbox" name="Calculate_Centrality" value="weight"> -->
			<a href="https://en.wikipedia.org/wiki/Closeness_centrality">
				What's Closeness Centrality ??? <br>
			</a> 
			<!-- <input type="text" name="input_path"
				placeholder="File Path" required /> -->
				 <input type="submit"
				value="Closeness Centrality" />
		</form>
	</div>



	<div class="form">
		<form action="calculate_katz_centrality">
			<br> <a href="https://en.wikipedia.org/wiki/Katz_centrality">
				What's Katz Centrality ??? </a><br>
			<!-- <input type="input" name="input_path" required/> -->
			<input type="submit" value="Katz Centrality" /><br> <br>
		</form>
	</div>

	<div class="form">
		<form action="final_centrality" method="post">
			<!-- <input type="checkbox" name="Calculate_Centrality" value="weight"> -->
			<!-- <a href="https://en.wikipedia.org/wiki/Centrality#Degree_centrality"> -->
			<!-- What's Degree Centrality ??? </a><br> <br>  -->
			Final Centrality<br> <input type="submit"
				value="Final Centrality" />
		</form>
	</div>
</body>
</html>