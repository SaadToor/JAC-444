package toor068;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {


        /* TASK 1 - build labs from files - at least two labs */

        System.out.println("\n\n *" + " TASK 1 " + "*");
        
        Labs labs = new Labs(9);
        System.out.println("\nCentennial Eglington Lab\n-----------");
        labs.addDevicesToLab("Centennial Eglington", "CentennialEglingtonLab.txt");
        System.out.println();
        System.out.println("\nJane Lab\n-----------");
        labs.addDevicesToLab("Jane", "JaneLab.txt");
        System.out.println();
        System.out.println("\nKing Lab\n-----------");
        labs.addDevicesToLab("King", "KingLab.txt");
        System.out.println();
        System.out.println("\nMarkham Lab\n-----------");
        labs.addDevicesToLab("Markham", "MarkhamLab.txt");
        System.out.println();
        System.out.println("\nNewnham Lab\n-----------");
        labs.addDevicesToLab("Newnham", "NewnhamLab.txt");
        System.out.println();
        System.out.println("\nNiagra Falls Lab\n-----------");
        labs.addDevicesToLab("Niagra Falls", "NiagraFallsLab.txt");
        System.out.println();
        System.out.println("\nNiagra-on-the-Lake Lab\n-----------");
        labs.addDevicesToLab("Niagra-on-the-Lake", "Niagra-on-the-LakeLab.txt");
        System.out.println();
        System.out.println("\nNiagra Welland Lab\n-----------");
        labs.addDevicesToLab("Niagra Welland", "NiagraWellandLab.txt");
        System.out.println();
        System.out.println("\nSeneca@York Lab\n-----------");
        labs.addDevicesToLab("Seneca@York", "YorkLab.txt");
        
        /* TASK 2 - ask for a device that is not in any lab inventory */

        System.out.println("\n\n *" + " TASK 2 " + "*");
        
        //Creating a Mobile device Mac OSX Lion2
        MobileDevice md = new MobileDevice("Mac OSX Lion2", 2);
        
        //Checking through the labs for the device
        Lab lab = labs.isThereDeviceInLabs(md);
        
        //If the device was no found it will return a null and print it doesnt exist
        if(lab == null)
        	System.out.println(Helper.printNonexistent(md));
        else
        	System.out.println("Device " + md.toString() + " is available");
        
         /* TASK 3 - ask for a device that is in a lab inventory
         *  issue a rent request and print the device
         *  issue the same rent request and print the device
         *  return the device
         *  issue the rent request with new dates and print the device
         */        
     
        System.out.println("\n\n *" + " TASK 3 " + "*");
        
        //Creating dates for the rent and due dates
        String rent = "10/30/2016", due = "11/10/2016";
        
        //Creating a new device
        md = new MobileDevice("Android6s", 3);
                
        //Checking through the labs for the device
        lab = labs.isThereDeviceInLabs(md);
        
        //Issue the rent request and rent the device 
		lab = labs.rentDeviceAvailable(md, rent, due);
		
		//If the lab is null then the device could not be rented successfully
		//else prints the available date and rented date
		if(lab != null){
			System.out.println(Helper.printAvailable(md, rent, lab));			
			System.out.println("wanted = " + md.rsInfo());
		}else
			System.out.println(Helper.printUnavailable(md, rent));        
		
		//Trying to rent the device again
		Lab lab2 = labs.rentDeviceAvailable(md, rent, due);
		
		if(lab2 != null){
			System.out.println(Helper.printAvailable(md, rent, lab2));
			System.out.println("Device " + md.rsInfo());
		}
		else
			System.out.println(Helper.printUnavailable(md, rent));
        
        //Return the device
        md.returnDevice(lab);
        
        //issue the rent request with new dates and print the device
        lab = labs.rentDeviceAvailable(md, rent = "11/30/2016", due = "12/10/2016");
              
        if(lab != null){
    		System.out.println(Helper.printAvailable(md, rent, lab));
    		System.out.println("wanted = " + md.rsInfo());
    	}else
    		System.out.println(Helper.printUnavailable(md, rent));       
        
         /* TASK 4 - ask for the same device in all labs
          * if you can find a lab, rent the device from that lab*/
          
        System.out.println("\n\n *" + " TASK 4 " + "*");
        
        //Creating a list of labs
        Vector<Lab> listOfLabs = new Vector<Lab>();
        
        //Checking through in the Labs class for the certain labs that have the device requested
        //Adds the labs found to the list
        for (int i = 0; i < labs.numberOfLabs; i++)
        	if(labs.labs[i].isThereDevice(md))
        		listOfLabs.addElement(labs.labs[i]);
        
        //Printing all the labs and that have the device
        for (Lab forLab : listOfLabs)
        	System.out.println("Device " + md.deviceName() + " is in " + forLab.labName);
        
        System.out.println();
        
        //Creating another list of labs for the rentable ones
        Vector<Lab> secondListOfLabs = new Vector<Lab>();
        
        /*Loops through the number of labs to find the MobileDevice that is the same
         * as the one requested, and then looks in the MobileDevice lab to make sure both labs
         * are the same, and are rentable. Adds the labs found to the list
         */
        for (int i = 0; i < labs.numberOfLabs; i++)
        	for (MobileDevice forMD : lab.devices)
            	if (forMD.equals(md))
            		if (md.lab.equals(lab))
            			secondListOfLabs.addElement(labs.labs[i]);
        
        //Printing all the rentable device and labs
        for (Lab forLab : listOfLabs)
        	System.out.println("Device " + md.deviceName() + " is in " + forLab.labName + " is available for rent :)");
        

        //TASK 5 - calculate maximum value tag for each lab 
        
        System.out.println("\n\n *" + " TASK 5 " + "*");
        
        //Looking through the labs and finding the maximum value tag from each lab
        for (int i = 0; i < labs.numberOfLabs; i++)
        	System.out.println("The maximum value tag is " + labs.labs[i].findMaximumValueTag() + " in " + labs.labs[i].labName);
        
       
        System.out.println("\n\n *" + " TASK 6 " + "*");
        //Creating a new device
        md = new MobileDevice("iPhone",45);
                
        //Checking through the labs for the device
        lab = labs.isThereDeviceInLabs(md);
        
        //Issue the rent request and rent the device 
        lab = labs.rentDeviceAvailable(md, rent = "03/15/2016", due = "05/03/2016");
        
        //Check if the device is rented
        if(md.isRented(lab))
        	System.out.println(Helper.printUnavailable(md, rent));
        else
        	System.out.println(Helper.printAvailable(md, rent, lab));
        
        /*Checking through the devices, 
         * if it is over due, 
         * or it's not over due or rented, 
         * or rented*/
        if(md.isDeviceOverdue())
        	System.out.println("Your device is over, please hand it in ASAP!");
        else if (!md.isDeviceOverdue() && !md.isRented(lab))
        	System.out.println("You dont have the device " + md.deviceName() + " rented");
        else
        	System.out.println("Your device " + md.deviceName() + " due date is until " + due); 
        
        /* Find the device in other labs
         * or give a "Cannot be found in any other lab" 
         */
                
        if(lab.isThereDevice(md))
        	System.out.println("Found device " + md.deviceName() + " in " + lab.labName + " and " + (lab.devices.size() > 1 ? lab.devices.size() - 1: " 1 ") + " more labs");
        else
        	System.out.println("Could not find device " + md.deviceName() + " in other labs");
        
        //Return the device before due date
        md.returnDevice(lab);
        
        //If the device is not rented, print the available date else its unavailable
        if(!md.isRented(lab))
        	System.out.println(Helper.printAvailable(md, rent = "06/01/2016", lab));
        else
        	System.out.println(Helper.printUnavailable(md, rent));
    }
}