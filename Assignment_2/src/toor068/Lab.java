package toor068;

import java.util.Vector;
import java.util.Objects;

/**
 * Lab Store all the information provided from the file,
 * such as labName, and devices. This class enables the 
 * usage of creating rent requests and adding new devices 
 * into the list of mobile devices
 */
public class Lab implements MaxTagValue {
	
    String labName;
    Vector<MobileDevice> devices;
    
    /**
     * Default ctr
     */
    public Lab(String labName) {
        this.labName = labName;
        devices = new Vector<MobileDevice>();
    }
    
    /**
     * Add all of the devices into the lab
     */
    public void addDevice(MobileDevice md) {
      	devices.addElement(md);
    }
    
    /**
     * Print the stored devices into a string format
     * @return all the device information
     */
    @Override
    public String toString() {
        String r = "";
        for (MobileDevice m : devices)
        	r += m.toString() + "\n";
        return r;
    }

    /**
     * Checks the devices from the lab and compares if both the lab device and user input device are equal
     * @returns true if devices are equal else false
     */
    public boolean isThereDevice(MobileDevice md) {
    	for (MobileDevice m : devices)
    		if (m.equals(md))
    			return true;
    	return false;	
    }
    
    /**
     * Creates a array of integers according to the amount of devices.
     * Store all the value tags from the devices into the array of integers
     * Uses the Finder class, to find the maximum value tag of all the devices in each lab
     * @returns the max value tag of each lab
     */
    public int findMaximumValueTag() {
    	int[] temp = new int[devices.size()];
        int i = 0;
        for (MobileDevice m : devices)
        	temp[i++] = m.valueTag;
    	return Finder.findMaximumValueTag(temp);
    }

    /**
     * @Returns true if both *this* lab attributes and the incoming lab attributes are equal
     */
    @Override
    public boolean equals(Object o) {
    	/** Null check */
    	if(o == null)
    		return false;
    	Lab l = (Lab)o;
        return Objects.equals(labName, l.labName)
        		&& Objects.equals(devices, l.devices);
    }
    
    @Override
    public int hashCode() {
        int result = labName != null ? labName.hashCode() : 0;
        result = 31 * result + (devices != null ? devices.hashCode() : 0);
        return result;
    }

    /**
     * Looks through the devices in the lab
     * @return true if the device is able to be rented
     */
    public boolean rentRequest(MobileDevice wanted, String requestDate, String dueDate) {
    	for (MobileDevice md : devices)
    		if (wanted.equals(md))
    			if(!wanted.isRented(this))
    				return wanted.rentDevice(requestDate, dueDate, this);	
    	return false;
    }
}
