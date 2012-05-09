<%@ page import = "twitter.UserRepository"%>
<%@ page import = "twitter.User"%>
<%
	UserRepository meUser = UserRepository.instance();
	meUser.bootstrap();	
	User cUser = meUser.getUser(request.getParameter("UserParam"));
	if(cUser != null){
		if(request.getParameter("passwordParam").equals(cUser.getPassword()))
		{
		session.setAttribute("loggedInUser",cUser);
		}
		else{
		System.out.println(request.getParameter("passwordParam"));
		System.out.println(cUser.getPassword());
		session.setAttribute("errorMsg", "You made an error");
%>
		<jsp:forward page="login.jsp"/>	
<%
		}
	}
	else{
		session.setAttribute("errorMsg","You made an error");
%>
		<jsp:forward page="login.jsp"/>
<%
	}
	
%>
<jsp:forward page = "home.jsp"/>
