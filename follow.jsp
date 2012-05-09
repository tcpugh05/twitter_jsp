<%@ page import = "twitter.UserRepository"%>
<%@ page import = "twitter.User"%>
<%
	System.out.println("In follow.jsp");
	UserRepository me = UserRepository.instance();
	me.bootstrap(); 
	User cUser = (User) session.getAttribute("loggedInUser");
	System.out.println("follow is" + request.getParameter("follow"));
	cUser.subscribeTo(me.getUser(request.getParameter("follow")));
	//session.getAttribute("loggedInUser",cUser);
	



%>
<jsp:forward page = "home.jsp"/>
