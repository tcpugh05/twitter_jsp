package twitter; 
import java.util.ArrayList;
import java.util.Collections; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
public class User{
	private String userName;
	private String password;
	private ArrayList<Tweet> tweets; 
	private ArrayList<User> subscribedTo; 
		

	User(String usr,String psswrd){
	userName = usr;
	password = psswrd;
	tweets = new ArrayList<Tweet>();
	subscribedTo = new ArrayList<User>();
	this.save();
	}
	User(){
	userName = null;
	password= null;
	tweets = new ArrayList<Tweet>();
	subscribedTo = new ArrayList<User>(); 
	}
	
	void setUserName(String str){
	userName = str; 
	this.save();
	}
	void setUserPassword(String str){
	password = str;
	this.save(); 
	}
	public void tweet(String text)
	{	
		if(tweets == null)
		{
		System.out.println("Tweets is empty");
		}
		else
		{
		System.out.println("Tweets not null");
		}
		System.out.println("IN USER.JAVA");
		Tweet addTweet = new Tweet(text,this);
		System.out.println("IN USER.java, before before add");
		if(addTweet ==null)
		{
		System.out.println("Tweet is null");
		}
		else{
		System.out.println("Tweet not null");
		}
		tweets.add(addTweet);
		System.out.println("IN USER.Java, just added tweet");
	this.save();
	}
	public ArrayList<Tweet> getTweets(){
		Collections.sort(tweets);
		return tweets;
	}
	
	public void subscribeTo(User otherUser)
	{
		 subscribedTo.add(otherUser);
		 this.save(); 
	}
	
	public void unsubscribeTo(User user)
	{
		int index = subscribedTo.indexOf(user);
	 	subscribedTo.remove(index); 
		this.save();
	}
	
	public ArrayList<User> getSubscribedTo(){
		return subscribedTo; 
	}
	
	public String getUserName(){
		return userName;
	}

	public String getPassword(){
		return password;
	}
	void load(String userFilename){
		System.out.println("Inside load:0"); 
		UserRepository me = UserRepository.instance(); 
		System.out.println("Inside load");
		try {
		String path = "/home/tpugh/tomcat/webapps/hw6/WEB-INF/classes/twitter/users/";
		BufferedReader in = new BufferedReader(new FileReader(path +userFilename));
		userName = in.readLine();	
		password = in.readLine();
		System.out.println("Inside load, username is : " + userName + " and password is : "+ password);
		String line = in.readLine();
		ArrayList <User> subscribeReplace;
		subscribeReplace = new ArrayList<User>();
		while(!line.equals(";"))
		{	
			System.out.println("About to add to subscribed" + line);
			subscribeReplace.add(me.getUser(line));
			line = in.readLine();
		}	
		subscribedTo = subscribeReplace; 
		line = in.readLine();
		ArrayList<Tweet> tweetsCopy;
		tweetsCopy = new ArrayList<Tweet>(); 
		while(line != null){
			System.out.println("About to add tweet :" + line);
			Tweet addTweet = new Tweet(line,this);
			line = in.readLine();
			// fix date
			System.out.println("Right before setdate: "+ line);
			addTweet.setDate(Long.parseLong(line));	
			System.out.println("Right after setdate");
			line = in.readLine();
		/*	boolean hasMatch = false;
			for(int i = 0; i < tweets.size(); i++)
			{
				if(tweets.get(i).getDate()==addTweet.getDate()){
					hasMatch = true; 
				}	
			}
			System.out.println("has match is" + hasMatch);
			if(hasMatch == true){*/
			tweetsCopy.add(addTweet);
		//	}
		}
		tweets = tweetsCopy;
		System.out.println("Leaving load");
		}
		catch(IOException e){
		}
	}
	private void save(){
	try{	
		System.out.println("Inside save try");
		String path = "/home/tpugh/tomcat/webapps/hw6/WEB-INF/classes/twitter/users/";
 
		File usr = new File(path + userName + ".txt");
		if(!usr.exists()){
			usr.createNewFile ();
		}
		System.out.println("Directory: " + usr.getCanonicalPath());
		BufferedWriter out = new BufferedWriter(new FileWriter(usr));
		out.write(userName+"\n");
		out.write(password+"\n");
		for(int i = 0; i < subscribedTo.size(); i++){
			System.out.println("Inside save/subscribed to loop :" + subscribedTo.size()); 
			User a = subscribedTo.get(i);
			out.write(a.getUserName() + "\n");
		}
		out.write(";" + "\n");
		for(int i= 0; i <tweets.size();i++){
			Tweet b = tweets.get(i);
			out.write(b.toString() + "\n");
		}
		out.close();
	}catch(IOException e) {
		System.out.println("Threw exception"); 
	}
	}
	
}


