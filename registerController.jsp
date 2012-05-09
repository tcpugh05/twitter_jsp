<%@ page import="twitter.UserRepository" %>
<%

	boolean mismatch = false;
	boolean empty = false;
	if(!request.getParameter("secPasswordParam").equals(request.getParameter("passwordParam"))){
	mismatch = true;
	System.out.print("sec password is" + request.getParameter("secPasswordParam"));
	System.out.print("first password" +request.getParameter("secPasswordParam"));
	}
	if(request.getParameter("passwordParam").isEmpty() || request.getParameter("userParam").isEmpty())
	{
	System.out.print("in empty");
	empty =true;
	}
	UserRepository meUser = UserRepository.instance(); 
	meUser.bootstrap();
	if(meUser.getUser(request.getParameter("userParam")) == null &&  mismatch == false  && empty == false){
		meUser.createNewUser(request.getParameter("userParam"),request.getParameter("passwordParam"));
		session.setAttribute("loggedInUser",meUser.getUser(request.getParameter("userParam"))); 
	}
	else
	{
		session.setAttribute("errorMsg","You made an error");
%>      
		<jsp:forward page="register.jsp?erROR=true"/>
	
<%	
	}


%>
	

<jsp:forward page="home.jsp"/> 




