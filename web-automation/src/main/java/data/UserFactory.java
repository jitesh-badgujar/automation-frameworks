package data;

public class UserFactory {
	public static User getStandardUser() {
		return new User("standard_user", "secret_sauce");
	}

	public static User getInvalidUser() {
		return new User("locked_out_user", "secret_sauce");
	}
}
