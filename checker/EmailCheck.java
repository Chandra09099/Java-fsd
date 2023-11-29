package checker;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

public class EmailCheck {

	public static void main(String[] args) {		
		 
		String regex = "\\d+"; 
		 
		Pattern pattern = Pattern.compile(regex); 
		 
		 
		 
		// Email matching 
		String email = "sivareddyh@gmail.com"; 
		String emailRegex = "^[a-zA-Z0-9_.-]+@gmail(.com)$"; 
		Pattern emailPattern = Pattern.compile(emailRegex); 
		Matcher emailMatcher = emailPattern.matcher(email); 
		 
		if(emailMatcher.matches()) 
		 
		System.out.println("\n The given email is a valid email"); 
		 
		else 
		 
		System.out.println("\n The given email is NOT a valid email"); 
		 
		 
		} 
		 
	

	}


