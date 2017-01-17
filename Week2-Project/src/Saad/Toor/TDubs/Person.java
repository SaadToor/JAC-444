package Saad.Toor.TDubs;

/** Creating class Person with:
 * The three fields, firstName, lastName, email
 * One abstract method */
public abstract class Person {
	
	// Creating private fields
	private String firstName;
	private String lastName;
	private String email;
	
	// Creating a abstract function
	public abstract void doing();
	
	// Creating all setters and getters
	public String getFN(){ return firstName; }
	public String getLN(){ return lastName; }
	public String getEmail(){ return email; }
	
	public void setFN(String fn){ this.firstName = fn; }
	public void setLN(String ln){ this.lastName = ln; }
	public void setEmail(String email){ this.email = email; }
}
