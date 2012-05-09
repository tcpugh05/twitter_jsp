package twitter;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.File;
import java.io.FilenameFilter; 
public class UserRepository {
	private static UserRepository theInstance;
	private  Hashtable<String,User> users;	
	public  UserRepository(){
	users = new Hashtable<String,User>();
	}
	public static UserRepository instance(){
		System.out.println("inside instance");
		if(theInstance == null){
			theInstance = new UserRepository();
			System.out.println("Instance is null");
		}
	
		return theInstance; 
	}
	public void bootstrap(){
	System.out.println("Inside bootstrap");
	String path = "/home/tpugh/tomcat/webapps/hw6/WEB-INF/classes/twitter/users";	
	File f = new File(path);

        String[] filenames = f.list(
            new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    if (name.endsWith(".txt")) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });
	for(int i = 0;  i <filenames.length; i++)
	{
		String person = filenames[i].substring(0, filenames[i].length()-4);
		System.out.println("Person is : " + person);
		if(!users.containsKey(person)){
		User newUser = new User();
		users.put(person,newUser);
		}
		System.out.println(filenames[i]);
	}
	for(int i = 0; i <filenames.length; i++)
	{
		String person = filenames[i].substring(0,filenames[i].length()-4);
		System.out.println("Person key is"+ person);
		if(users.containsKey(person)){
		User cUser = users.get(person);
		cUser.load(filenames[i]);
		}
		System.out.println(users.get(person).getUserName());
		System.out.println(users.get(person).getPassword());
		
	}
	System.out.println("Leaving bootstrap"); 
}
	public  User createNewUser(String username, String password){
		System.out.println("Passed username is " + username);
		User newUser = new User(username,password);
		if(users == null)
		{
			System.out.println("users is null");
		}
		else{
			System.out.println("user is not null");
		}
		System.out.println("username is " +  newUser.getUserName());
		users.put(newUser.getUserName(),newUser);
		return newUser; 
	}
	
	public  User getUser(String username){	
		if(users == null)
		{
			System.out.println("users is null in getUser");
		}
		else{
			System.out.println("user is not null in getUser");
		}
		System.out.println("IN GETUSER username is " + username);
		if(users.containsKey(username)){
			return users.get(username);
		}
		else
			return null; 
	}
	
	public  ArrayList<User> getAllUsers(){
		ArrayList<User> list1 = new ArrayList<User>(users.values());
		return list1;
	}
}
