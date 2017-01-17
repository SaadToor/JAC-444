package Saad.Toor.TDubs;

public class Meeting {
	public static void main(String args[]){
		
		//Creating the 6 different People
		Student studentA = new Student();
		Student studentB = new Student();
		
		Professor professorA = new Professor();
		Professor professorB = new Professor();
		
		Staff staffA = new Staff();
		Staff staffB = new Staff();
		
		Person[] working = new Person[6];
		
		//Initializing all Student fields
		studentA.setFN("John");
		studentA.setLN("Smith");
		studentA.setEmail("jsmith@myseneca.ca");
		studentA.setProg("CPD");
		
		studentB.setFN("Colin");
		studentB.setLN("Thomas");
		studentB.setEmail("jsmith@myseneca.ca");
		studentB.setProg("CPD");
		
		//Initializing all Professor fields
		professorA.setFN("Jordan");
		professorA.setLN("Anastasiade");
		professorA.setEmail("jordan.anastasiade@senecacollege.ca");
		professorA.setOffice("T1034");
		
		professorB.setFN("Wei");
		professorB.setLN("Song");
		professorB.setEmail("wei.song@senecacollege.ca");
		professorB.setOffice("T2099");
		
		//Initializing all Staff fields
		staffA.setFN("Jack");
		staffA.setLN("Brown");
		staffA.setEmail("jack.brown@senecacollege.ca");
		staffA.setTitle("Admin");
		
		staffB.setFN("Paul");
		staffB.setLN("Miller");
		staffB.setEmail("paul.miller@senecacollege.ca");
		staffB.setTitle("Technical Support");
		
		//Add/assign the 6 objects to the array.
		working[0] = studentA;
		working[1] = studentB;
		working[2] = professorA;
		working[3] = professorB;
		working[4] = staffA;
		working[5] = staffB;
		
		/*Use for-loop to print out the info of each 
		 * object in the array by calling toString() and 
		 * doing() methods.*/
		for(int i = 0; i < 6; i++){
			System.out.println(working[i]);
			working[i].doing();
		}
		
		Talkable[] meeting = new Talkable[6];
		
		//Add/assign the 6 objects to the array.
		meeting[0] = studentA;
		meeting[1] = studentB;
		meeting[2] = professorA;
		meeting[3] = professorB;
		meeting[4] = staffA;
		meeting[5] = staffB;
		
		/*Use for-each-loop to print out the info of each 
		 * object in the array by calling toString() and 
		 * doing() methods.*/	
		for(Talkable mt : meeting)
			mt.say();
	}
}
