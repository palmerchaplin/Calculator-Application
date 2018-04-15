package calcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Database {
	
	 private Connection conn = null; 
	 private Statement stmt = null;
	 private ResultSet rset = null;
	 
	 private String url = "jdbc:mysql://localhost:3306/CalcAppUsers";
	 
	 final static private String host = "smtp.gmail.com";
	 
	 final static private String usernameEmail = "CLUCSC335.2016";
	 final static private String passwordEmail = "CLUC$C335";
	 
	 // -- this is the username/password, created during installation and in MySQL Workbench
	    //    When you add a user make sure you give them the appropriate Administrative Roles
	    //    (DBA sets all which works fine)
	    private String user = "root";
	    private String password = "password";

		public Database(USER user1) {
			try {
	            // -- make the connection to the database
				conn = DriverManager.getConnection(url, user, password);
	            
				// -- These will be used to send queries to the database
	            stmt = conn.createStatement();
	            rset = stmt.executeQuery("SELECT VERSION()");

	            if (rset.next()) {
	                System.out.println(rset.getString(1));
	            }
	            
	            // -- insert record into database
	            
	            String insert = "insert into users values('" + user1.getUsername() + "', '" + user1.getPassword() + "', '" + user1.getEmailAdd() + "', " + user1.getLockout() + ");";
	            System.out.println(insert);
	            stmt.executeUpdate(insert);
	            
	            String delete = "Delete from users where username = '';";
	            stmt.executeUpdate(delete);
	            
	            // -- update an existing record
	            String update = "update users set username='name17' where username='name16';";
	            stmt.executeUpdate(update);

	            // -- retrieve record(s) from database
	            String command = "SELECT * FROM users;";
	            System.out.println(command);
	            // -- a query will return a ResultSet
	            // -- city is a table within the world database
	            rset = stmt.executeQuery(command);
	            
	            // -- the metadata tells us how many columns in the data
	            ResultSetMetaData rsmd = rset.getMetaData();
	            int numberOfColumns = rsmd.getColumnCount();
	            System.out.println("columns: " + numberOfColumns);
	            
	            // -- loop through the ResultSet one row at a time
	            //    Note that the ResultSet starts at index 1
	            while (rset.next()) {
	            	// -- loop through the columns of the ResultSet
	            	for (int i = 1; i < numberOfColumns; ++i) {
	            		System.out.print(rset.getString(i) + "\t\t");
	            	}
	            	System.out.println(rset.getString(numberOfColumns));
	            }

			} catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}

		}
		
		public String getRecordByUname(String username1) 
		{
			try {
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.createStatement();
	            rset = stmt.executeQuery("SELECT VERSION()");
	            
	            
	            String command = "SELECT * FROM users WHERE username = '" + username1 + "';";
	            System.out.println(command);
	            // -- a query will return a ResultSet
	            // -- city is a table within the world database
	            rset = stmt.executeQuery(command);
			} catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
            
			return rset.toString();
            
            
            
		}

		public String getRecordByPword(String pword1) 
		{
			try {
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.createStatement();
	            rset = stmt.executeQuery("SELECT VERSION()");
	            
	            
	            String command = "SELECT * FROM users WHERE password = '" + pword1 + "';";
	            System.out.println(command);
	            // -- a query will return a ResultSet
	            // -- city is a table within the world database
	            rset = stmt.executeQuery(command);
			} catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
            
			return rset.toString();
			
		}
		
		public int incrementLock(String uname)
		{
			int g = 0;
			int x = 0;
			try {
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.createStatement();
	            rset = stmt.executeQuery("SELECT VERSION()");
	            
	            
	            String command = "SELECT lockout FROM CALCAPPUSERS.users WHERE username = '" + uname + "';";
//	            //This is not letting me get an actual value from the result set 
//	            rset = stmt.executeQuery(command);
//	            g = rset.getInt("lockout");
//	            x = g;

	            if(g >= 3)
	            {
	            	String update = "update users set lockout= 0 where username='" + uname + "';";
	            	stmt.executeUpdate(update);
	            	String update2 = "update users set password= password where username='" + uname + "';";
	            	stmt.executeUpdate(update);
	            	//NEED TO ACCESS EMAIL HERE, only used my email to test email was arriving because only email I was using.
	            	//would do so with execute query with getstring method for the email.
	            	sendEmail("pchaplin@callutheran.edu", "New password: password");
	            }
	            else{

	            	String update = "update users set lockout= lockout+1 where username='" + uname + "';";
	            	System.out.println(update);
	            	// -- a query will return a ResultSet
	            	// -- city is a table within the world database
	            	command = "SELECT lockout FROM CALCAPPUSERS.users WHERE username = '" + uname + "';";
	            	rset = stmt.executeQuery(command);
	            	stmt.executeUpdate(update);

	            }
	            
			} catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
			
			return x;
		}
		
		public static void sendEmail(String email1, String message1)
		{
			// -- set up host properties
						Properties props = new Properties();
						props.put("mail.smtp.auth", "true");
						props.put("mail.smtp.starttls.enable", "true");
						props.put("mail.smtp.host", host);
						props.put("mail.smtp.port", "587");

						// -- Get the Session object.
						Session session = Session.getInstance(props,
								new javax.mail.Authenticator() {
									protected PasswordAuthentication getPasswordAuthentication() {
										return new PasswordAuthentication(usernameEmail, passwordEmail);
									}
								});

						// -- Set up the sender's email account information
						String from = "CLUCSC335@gmail.com";

						// -- Set up the recipient's email address
						String to = email1;
								
						try {
							// -- Create a default MimeMessage object.
							Message message = new MimeMessage(session);

							// -- Set From: header field of the header.
							message.setFrom(new InternetAddress(from));

							// -- Set To: header field of the header.
							message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

							// -- Set Subject: header field
							message.setSubject("Calculator Account");

							// Now set the actual message
							message.setText(message1);
//							message.setText("You should be starting your project soon as the semester is nearly over\n");
							// -- Send message
							// -- use either these three lines or...
							//Transport t = session.getTransport("smtp");
							//t.connect();
							//t.sendMessage(message, message.getAllRecipients());
							
							// -- .. this one (which ultimately calls sendMessage(...)
							Transport.send(message);

							System.out.println("Sent message successfully....");

						} catch (MessagingException e) {
							throw new RuntimeException(e);
						}
					}

		
		/**
		 * @param args
		 */
		public static void main(String[] args) {

			Database dbc = new Database(null);
			
			
		}

	}
