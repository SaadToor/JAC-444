package Saad.Toor.IPv4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IPv4 {
	
	private int[] ipv4 = new int[5];
	
	/** Reads the file and set all values accordingly */
	public IPv4(String fileName){
	
	readFromFile(fileName);
	
	System.out.println("This is the ip address entered read from the file\n"
			       + "-------------------------------------------------");
	for(int i = 0; i < 5; i++)
		System.out.print(ipv4[i] + ( i < 3 ? "." : "" ) + ( i == 3 ? "/" : "" ));
	System.out.println();
	}
	
	public void readFromFile(String fileName){
        String s = null;      
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(
							"C:/Users/saad3/Desktop/Workspace"
							+ "/Subnet Calculator/src/" + fileName));
			
			while ((s = br.readLine()) != null){
				String[] nums = s.split("[\\.\\/]");
				for(int i = 0; i < 5; i++)
					ipv4[i] = Integer.valueOf(nums[i]).intValue();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File was not found, or does not exist!\nPlease enter the proper file name.");
		} catch (IOException e) {
			System.out.println("File was not readable, or damaged!\nPlease enter a differnet file for testing.");
		}
	}
}
