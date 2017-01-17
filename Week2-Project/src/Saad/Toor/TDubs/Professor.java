package Saad.Toor.TDubs;

class Professor extends Person implements Talkable{
	
	// Creating the office String
	private String office;
		
	/**Implementing the abstract void doing method
	 * Printing the results*/
	public void doing(){
		System.out.println("Teaching as professor!");
	}
		
	/**Implementing the say method in interface class*/
	public void say() {
		System.out.println("Hello! My name is " + getFN()  + " " + getLN() +  ", and I'm in " + office);
	}
	
	/**Overriding the toString function for different results*/
	@Override 
	public String toString(){
		return "Faculty [office=" + office + ", [firstName=" + getFN() + ", lastName=" + getLN() + ", email=" + getEmail() + "]]";
	}
	
	// Creating all setters and getters
	public void setOffice(String office){ this.office = office; }
	public String getOffice(){ return office; }
}
