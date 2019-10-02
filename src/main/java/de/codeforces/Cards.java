package de.codeforces;
import de.codeforces.utils.Input;

public class Cards {

    public static void main(String[] args) {
    	
    	System.out.println(new Cards().getCalculatedString(Input.getConsoleInput().getLines(2)));
    }
    
    public String getCalculatedString(String [] input) {
    	String stringForZ = "";
    	String stringForN = "";
    	
    	for (char element : input[1].toCharArray()) {
    		if ('z' == element) {
    			stringForZ += "0 ";
    		}else {
    			if ('n' == element) {
    				stringForN += "1 ";
    			}
    		}
    	}
    	return stringForN + stringForZ;
    }

}
