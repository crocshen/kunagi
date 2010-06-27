package scrum.client.admin;

public interface RegisterDataProvider {

	String getUsername();

	String getPassword();

	String getEmail();

	void setFailed(String message);

	void setSuccessful(String message);

	void clear();

}
