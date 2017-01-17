package toor068;

/**
 * MobileDevice store's the information of a device in the lab with,
 * deviceName, valueTag, lab, and private rs(RentSettings).
 * Device's can also be rented within in a lab.
 */
public class MobileDevice {

    String       deviceName;  // the device name
    int          valueTag;    // an integer between -100 and 100
    Lab          lab;         // the lab having this device it its inventory
    public RentSettings rs;          // rent settings

    /**
     * Default CTR
     * Make all the values null for memory allocation
     */
    public MobileDevice() {
    	deviceName = null;
    	valueTag = 0;
    	lab = null;
    	rs = null;
    }
    
    /**
     * CTR - Sets the deviceName and the valueTag of each device
     */
    public MobileDevice(String deviceName, int valueTag) {
    	this.deviceName = deviceName;
    	this.valueTag = valueTag;   	
    }
    
    /**
     * Set the Lab manually
     */
    public void setLab(Lab lab) {
    	if(lab != null)
    		this.lab = lab;
    	else
    		this.lab = null;
    }
    
    // set the rent dates; if dates are not valid catch DateFormatException and return false,
    // if rentDate > dueDate catch RentPeriodException and return false
    // if one the exceptions occur there is no RentSettings object
    /**
     * sets the rent dates; 
     * if dates are not valid catch DateFormatException and @return false
     * if rentDate > dueDate catch RentPeriodException and @return false
     * if one the exceptions occur there is no RentSettings object*/
    public boolean rentDevice(String rentDate, String dueDate, Lab lab) {	    	    	
    	RentSettings rs = null;   	
    	try{
        	rs = new RentSettings(rentDate, dueDate, lab);       	        	        	
        }catch(DateFormatException e){
        	System.out.println(e.toString());
        	return false;
        }catch(RentPeriodException e2){
        	System.out.println(e2.toString());
        	return false;
        }
        this.rs = rs;
        this.lab = lab;
        return true;
    }

    // destroy the RentSettings object for this device
    /**
     * Returns the device by destroying the RentSettings
     */
    public void returnDevice(Lab lab) {
    	this.rs  = null;
    	this.lab = lab;
    }
    
    // return the date when this device is available
    /**
     * @returns when the device is available
     */
    public String availableDate(Lab lab) {
    	if (rs == null)
    		return "There are no rent settings, rent date, and due date?";
    	return Helper.printAvailable(this, rs.rentDate, lab);
    }

    // returns true if the current date is greater than the due date
    /**
     * If the current date is greater than the due date
     * @return false else true
     */
    public boolean isDeviceOverdue() {
    	try {
			if(Helper.timeDifference(Helper.getCurrentDate(), rs.dueDate) < 0)
				throw new DateFormatException();
		} catch (DateFormatException e) {
			return false;
		} catch (NullPointerException npe){
    		return false;
		}
    	return true;
    }
    
    /**
     * Checks through the lab for the same device.
     * Checks if the borrowed for RentSettings is true
     * @param Lab l
     * @return true else false
     */
    public boolean isRented(Lab l) {
    	if (rs != null)
    		for (MobileDevice md : l.devices)
        		if (this.equals(md))
        			if(rs.borrowed)
        				return true;
    	return false;
	}

    /**
     * @return RentSettings
     */
    public RentSettings getRs() {
        return this.rs;
    }
    
    /**
     * Combines the device.toString() and rs.toString() to return both information
     * @return device.toString() + rs.toString()
     */
    public String rsInfo(){
    	if (rs != null)
    		return toString() + rs.toString();
    	return "";
    }

    @Override
    public boolean equals(Object o) {
    	if(o == null)
    		return false;
    	if(!(o instanceof MobileDevice))
    		return false;
        
    	return ((MobileDevice)o).deviceName.equals(deviceName)
    			&& valueTag == ((MobileDevice)o).valueTag;
    }

    @Override
    public int hashCode() {
        int result = deviceName != null ? deviceName.hashCode() : 0;
        result = 31 * result + valueTag;
        return result;
    }
    
    @Override
    public String toString() {
    	String s = "";
    	if(lab != null)
    		s = "(" + deviceName + ", " + valueTag + " => " + lab.labName + ")";
    	else if (rs != null)
    		s = deviceName();
        return s;
    }
    
    /**
     * @return deviceName + valueTag*
     */
    public String deviceName() {
        return "(" + deviceName + ", " + valueTag + ')';
    }

    private class RentSettings {

        private String rentDate;          // date when the item is requested
        private String dueDate;           // date when the item must be returned
        private boolean borrowed = false; // true if the item is rented

        //default ctr
        /**Default CTR Checks for rent and due date validation, throws DateFormatException*/
        private RentSettings() throws DateFormatException {
        	if(!Helper.isValidDate(rentDate) && !Helper.isValidDate(dueDate))			
        		throw new DateFormatException();
        }
        
        // private ctr must throw DateFormatException and RentPeriodException
        /**Checks for rent and due date validation, throws DateFormatException
         * Checks if the rent date is greater than the due date, throws RentPeriodException
         * Sets the rent and due dates according to 
         * @param String rentDate
         * @param String dueDate*/
        private RentSettings(String rentDate, String dueDate, Lab lab) throws DateFormatException, RentPeriodException {
        	if(Helper.isValidDate(rentDate) && Helper.isValidDate(dueDate)){
        		if(Helper.timeDifference(rentDate, dueDate) < 0)
        			throw new RentPeriodException();
        		
        		this.rentDate = rentDate;
        		this.dueDate = dueDate;
        		borrowed = true;
        	}else
    			throw new DateFormatException();
        }
        
        @Override
        public String toString() {
            return "RentSettings{" +
                    "rentDate='" + rentDate + '\'' +
                    ", dueDate='" + dueDate + '\'' + MobileDevice.this.lab.labName +
                    ", borrowed=" + borrowed +
                    '}';
        }
    }
}
