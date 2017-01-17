package toor068;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Labs holds a array of lab.
 * Reads from the file and inputs all the information into each individual lab.
 * Labs can also perform a check for a device in a different lab,
 * and if it's available
 */
public class Labs {

    public Lab[] labs;        // a collection of labs of type array
    public int numberOfLabs;  // number of labs in collection
    private int counter = 0;
    
    /**
     * Sets the number of labs
     */
    public Labs(int numberOfLabs) {
    	this.numberOfLabs = numberOfLabs;
    	labs = new Lab[numberOfLabs];
    }
    /**
     * Reads all the information from a file 
     * @returns all the lab/s collected
     */
    public Lab addDevicesToLab(String labName, String labFileName) {
        Lab lab = buildLabFromFile(labName, labFileName);
        System.out.println("Lab = " + labName + "\n[\n" + lab + "]");
        return lab;
    }

    /**
     * Takes the lab name, and name of the file
     * Reads from the file
     * Stores all the new mobile devices and sets the labs
     * @returns lab
     */
    public Lab buildLabFromFile(String labName, String fileName) {
        Lab lab = new Lab(labName);
        MobileDevice md = null;
        String s;
        
        try {
        	BufferedReader br = new BufferedReader(new FileReader("C:/Users/TDoubleAKing/Desktop/Assignment_2" + "/src/" + fileName));
            while ((s = br.readLine()) != null) {
            	String[] sp = s.split(",");
            	
            	md = new MobileDevice(sp[0],Integer.valueOf(sp[1]).intValue());
            	
            	md.setLab(lab);
            	
            	lab.addDevice(md);
            }
            
            if(numberOfLabs > counter)
            	labs[counter] = lab;
            counter++;
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lab;
    }
    
    /**
     * Looks through the array of labs and checks if there is a device in the lab
     * @returns null if no devices are found
     */
    public Lab isThereDeviceInLabs(MobileDevice md) {
    	for(Lab l : labs)
        	if(l.isThereDevice(md))
        		return l;
        return null;
    }

    /**
     * Scans through the labs for a available device
     * @returns a foundLab
     */
    public Lab rentDeviceAvailable(MobileDevice md, String requestDate, String dueDate) {
        Lab foundLab = null;
        for(Lab l : labs)
        	if (l.rentRequest(md, requestDate, dueDate))
        		foundLab = l;
        return foundLab;
    }
}
