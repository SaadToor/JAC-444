package Saad.Toor.TDubs;

class Student extends Person implements Talkable{
	
	// Private string program
	private String program;
			
	/**Implementing the abstract void doing method
	 * Printing the results*/
	public void doing(){
		System.out.println("Studying as student!");
	}
		
	/**Implementing the say method in interface class*/
	public void say() {
		System.out.println("Hello! My name is " + getFN() + " " + getLN() + ", and I'm in " + program + " program");
	}
	
	/**Overriding the toString function for different results*/
	@Override 
	public String toString(){
		return "Student [program=" + program + ", toString()=Person [firstName=" + getFN() + ", lastName=" + getLN() + ", email=" + getEmail() + "]]";
	}
	
	// Creating all setters and getters
	public void setProg(String prog){ this.program = prog; }
	public String getProg(){ return program; }
}