package calcApp;

//RegexTestHarness class from Dr. Reinhart's given code.
public class USER extends RegexTestHarness{

	private String username;
	private String password;
	private String emailAdd;
	private int lockout;
	
	//default constructor
	public USER()
	{
		username = "";
		password = "";
		emailAdd = "";
		lockout = 0;
	}
	
	//User enters username, password, and email
	public USER(String email, String uname, String pword)
	{
		username = uname;
		password = pword;
		emailAdd = email;
		lockout = 0;
	}

	//checks if username is of correct format. must be at least 1 characters long.
	public static boolean validateUname(String uName)
	{
		boolean check = true;
		if(uName.length() < 1)
		{
			check = false;
		}
		else
		{
			check = true;
		}
		
		return check;
	}
	
	//check password from Dr. Reinhart's RegexTestHarness class.
	public static boolean validatePword(String pWord)
	{
		return validPassword(pWord);
	}
	
	//check email from Dr. Reinhart's RegexTestHarness class.
	public static boolean validateEmail(String mail)
	{
		return validEmailAddress(mail);
	}
	
	//getters and setters for all variables
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public int getLockout() {
		return lockout;
	}

	public void setLockout(int lockout) {
		this.lockout = lockout;
	}
	
	
}
