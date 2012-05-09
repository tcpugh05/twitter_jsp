<%@ page import = "twitter.UserRepository"%>
<%@ page import = "twitter.User"%>
<%@ page import = "twitter.Tweet"%>
<%
	User cUser = (User) session.getAttribute("loggedInUser");
	if(cUser == null)
	{
	System.out.print("IN TWEET.JSP:NULL ");
	}
	System.out.print("IN TWEET.JSP. tweet is " + request.getParameter("tweet"));
	String param = request.getParameter("tweet");
	System.out.print("IN TWEET.JSP param is " + param);
	cUser.tweet(param);




%>
<jsp:forward page = "home.jsp"/>
