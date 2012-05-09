package twitter;
import java.util.Date;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Calendar;
public class Tweet implements Comparable<Tweet>{
	private String text;
	private Date date;
	private User author;
	Tweet(String txt, User thr)
	{
		long tmp;	
		System.out.println("IN TWEETJAVA CONSTRUCTOR ");
		text = txt;
		System.out.println("A");
		author = thr; 
		System.out.println("B");
		date = new Date();
		System.out.println("C");
	}
	
	public String getText(){
	return text;  
	}
	
	public User getAuthor(){
	return author;
	}

	public Date getDate(){
	return date; 
	}

	public int compareTo(Tweet other){
	return this.getDate().compareTo(other.getDate());
	}
	public String toString(){
	return  text + "\n" + date.getTime();	
	}
	public void setDate(long time){
		System.out.println("Inside setDate");
		date  = new Date(time); 
	}
}
