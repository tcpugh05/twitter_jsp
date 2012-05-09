<%@ page import  = "twitter.UserRepository"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collections"%>
<%@ page import="twitter.User"%>
<%@ page import="twitter.Tweet"%>
<%@ page import="java.util.Date"%>
<html>
<head><head/>
<body>
	
	<%@ include file="menu.jsp"%>
	<%
	User cUser = (User)session.getAttribute("loggedInUser");
	try
	{	
	out.println("<h1>Welcome, " + cUser.getUserName() + "</h1>");
	%>
	<form action ="tweet.jsp" method = "GET">
		What's on your mind </br>
		<input type=text size=20 name="tweet"/>
		<input type=submit name=submit value ="Tweet it!">
	</form>
	<%
	ArrayList<User> followees = new ArrayList<User>(); //all people followed
	ArrayList<Tweet> allTweets = new ArrayList<Tweet>();//all tweets from all peopel followed
	followees = cUser.getSubscribedTo();
	if(followees != null) {
		for(int i= 0; i < followees.size(); i++){
			allTweets.addAll(followees.get(i).getTweets());
			System.out.println("followes size is " + i);
			}
	}
	Collections.sort(allTweets);
	Collections.reverse(allTweets);
	for(int i = 0; i < allTweets.size();i++){
		Tweet oneTweet = allTweets.get(i);
		User aUser = oneTweet.getAuthor();
		Date cDate = oneTweet.getDate();
		System.out.println("number of tweets is "+ i);
	//	String reportDate = cDate.ToString();
		out.print(aUser.getUserName() + ": " + oneTweet.getText() + " " + cDate);
		out.print("<a href=\"unfollow.jsp?unfollow=" +  aUser.getUserName()+ "\" >Stop Following</a>");
		out.print("</br>");
	}	


	%>

	<form action="follow.jsp" method="GET">
	Follow this user:
	<%
	UserRepository meUser = UserRepository.instance();
	meUser.bootstrap();
	ArrayList<User> list = meUser.getAllUsers();
	out.print("<select name=\"follow\">");
	for(int i = 0; i < list.size(); i++){
		User dUser = list.get(i);
		String nm = dUser.getUserName();
		if(nm != cUser.getUserName()  && (followees.contains(dUser)==false)) {
			out.print("<option value =\""+nm+ "\">" +nm + "</option>");
		}
	}
	out.print("</select>");
	}
	catch(Exception e)
	{
%>
	<jsp:forward page = "register.jsp"/>
<%	
	}
	%>
	<input type=submit  value="Follow!"/>
	</form>



</body>
</html>
