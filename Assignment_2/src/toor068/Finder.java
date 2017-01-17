package toor068;

/** Scan through the array of inputs for the max value tag */
public class Finder {
	/**
	 * The method returns an integer.
	 * The integer is the greatest value of all tagValues of the lab devices
	 */ 
    public static int findMaximumValueTag(int[] input) {
        int maxElement = -100;
        for (int i = 0; i < input.length; i++)
        	if (input[i] < 100 && input[i] > -100)
        		if (input[i] > maxElement)
        			maxElement = input[i];
        return maxElement;
    }
}
