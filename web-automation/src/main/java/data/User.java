package data;

public class User {

	private String userName;
	private String password;

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public static User getStandardUser() {
		return new User("standard_user", "secret_sauce");
	}

	public static User getInvalidUser() {
		return new User("locked_out_user", "secret_sauce");
	}

}
