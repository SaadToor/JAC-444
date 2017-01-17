package Saad.Toor.TDubs;

class Staff extends Person implements Talkable{
	
	// Creating the title string
	private String title;
		
	/**Implementing the abstract void doing method
	 * Printing the results*/
	public void doing(){
		System.out.println("Working as staff!");
	}
		
	/**Implementing the say method in interface class*/
	public void say() {
		System.out.println("Hello! My name is " + getFN() + " " + getLN() +  ", and my title is " + title);
	}
	
	/**Overriding the toString function for different results*/
	@Override 
	public String toString(){
		return "Staff [title=" + title + ", [firstName=" + getFN() + ", lastName=" + getLN() + ", email=" + getEmail() + "]]";
	}
	
	// Creating all setters and getters
	public void setTitle(String title){ this.title = title; }
	public String getTitle(){ return title; }
}