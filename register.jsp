<HTML>
<HEAD></HEAD>
<BODY>
	<%@ include file="menu.jsp"%>
	<%
		if(session.getAttribute("errorMsg") != null){
		out.print(session.getAttribute("errorMsg"));
		session.setAttribute("errorMsg","");
		}
	%>
	<H1>Register</H1>
	<form action = "registerController.jsp" method="GET">
		Pick a username
		<input type=text size=20 name="userParam">
		<br/>
		Pick a password
		<input type=text size=20 name="passwordParam">
		<br/>
		Re-enter a password
		<input type=text size=20 name="secPasswordParam">
		<input type=submit name=submit value="Login"/> 
	</form>

</BODY>
</HTML>
