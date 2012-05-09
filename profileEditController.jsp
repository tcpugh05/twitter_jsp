<%@ page import = "f4k.User"%>
<%@ page import = "f4k.Profile"%>
<%
	User loggedInUser=(User)session.getAttribute("loggedInUser");
	Profile userProfile = loggedInUuser.getProfile; 
	userProfile.setFavTVShow(request.getParameter("tvParam"));
	userProfile.setFavFood(request.getParameter("foodParam"));
	userProfile.setFavColor(request.getParameter("colorParam"));
	userProfile.setFavFood(request.getParameter("foodParam"));
	userProfile.setFavAnimal(request.getParameter("animalParam"));
	userProfile.setFavBook(request.getParameter("bookParam"));
	userProfile.setDreamJob(request.getParameter("jobParam"));
	userProfile.setFavMusic(request.getParameter("musicParam"));

%>
