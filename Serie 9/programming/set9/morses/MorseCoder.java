package programming.set9.morses;

import java.io.*;
import java.nio.charset.Charset;

public class MorseCoder {
	private static String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
	private static String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","-----",".----","..---","...--","....-",".....","-....","--...","---..","----."};
																																															  //25
	/**
	 * Returns a new string which is the morse code version of the input string.
	 * Each word is on a separate line. The morse representation of each
	 * character of the input string is separated from the next by a space
	 * character in the output string.
	 * 
	 * @param input
	 *            the input string.
	 * @return the morse code version of the input string, ignoring all
	 *         characters in the input string that cannot be represented in
	 *         international morse code.
	 */
	public static String encode(String input) {
		String output = "";
		String[] word = input.split("[ \\n]+"); // split input String when space appears 
		for (String words : word){
			char[] chars = words.toCharArray(); //splits words in letter
			for (char letter : chars){
				String letters = String.valueOf(letter); //cast Char to String
				byte[] bytes = letters.getBytes(Charset.forName("US-ASCII")); //get ascii number from letter
				int n = 0;
				if (bytes[0] >= 97 && bytes[0] <=122){ //checks if lower-case
					n = bytes[0] - 97; //calculates array index
					output += code[n]; 
					output += " ";
				}
				else if (bytes[0] >= 65 && bytes[0] <= 90){ //checks if upper-case
					n = bytes[0] - 65; //calculates array index
					output += code[n];
					output += " ";
				}
				else if (bytes[0] >= 48 && bytes[0] <= 57){ //checks if number
					n = bytes[0] - 22; //calculates array index
					output += code[n];
					output += " ";
				}
				else continue; //when unknown symbol
				}
			output += "\n"; 
			}
		return output;
		}
		
	    
	
	
	
	/**
	 * Returns a new string which is the natural-language version of the input
	 * string, which is assumed to be in morse code format as produced by the
	 * encode method.
	 * 
	 * @param input
	 *            morse code input string.
	 * @return natural language version or {@code null} if the input string
	 *         could not be properly parsed.
	 */
	public static String decode(String input) {
		String output = "";
		int i = 0;
		String[] word = input.split("\\n"); //splits String when a new Line appears
		for (String words : word){
			String[] chars = words.split(" +"); //splits String when space appears
			for (String letter : chars){
				i = 0;
				for (String morse : code){ 
					if (morse.equals(letter))break;
					else i += 1;
				}
				try {
				output += alphabet[i];
				} catch(ArrayIndexOutOfBoundsException arrayException){ //when unknown symbol
					return null;
				}
			}
			output += " ";
		}
		
		return output;
	}
}

