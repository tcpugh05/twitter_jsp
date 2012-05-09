<HTML>
<HEAD></HTML>
<TITLE></TITLE>
<BODY>
	<%@ include file="menu.jsp"%>
	<%if(session.getAttribute("errorMsg") != null){
	out.print(session.getAttribute("errorMsg"));
	session.setAttribute("errorMsg","");
	}
	%>
	
	<H1>Login</H1>
	<form action="loginController.jsp" method= "GET">
		Enter your username
		<input type=text size=20 name="UserParam"/>
		<br/>
		Enter your password
		<input type=password size=20 name="passwordParam"/>
		<input type=submit name=submit value="Login"/>
	</form>

</BODY>
</HTML>
