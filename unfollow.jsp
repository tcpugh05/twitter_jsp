<%@ page import = "twitter.UserRepository"%>
<%@ page import = "twitter.User"%>
<%
	UserRepository me = UserRepository.instance();
	me.bootstrap();
	User cUser = (User) session.getAttribute("loggedInUser");
	cUser.unsubscribeTo(me.getUser(request.getParameter("unfollow")));



%>
<jsp:forward page = "home.jsp"/>
