package programming.set11.ciphers;

public class CaesarCipher {

	CryptMode mode; 
	int k;

	public CaesarCipher(CryptMode mode, int k) {
		this.k = k;
		this.mode = mode;
	}

	/**
	 * Encrypts or decrypts the given text, depending on the mode of operation
	 * this cypher was created for.
	 * 
	 * @param text
	 *            the text to encode.
	 * @return encryted or decrypted version of the text.
	 */
	public String encode(String text) {
		int n = 0; //letter index
		String output = "";
		if (mode == CryptMode.ENCRYPT) {
			char str[] = text.toCharArray();
			for (char letter : str) { // iterates through string
				n = letter; //converts char to its ascii number
				n = shift(n, k); //shift the letter with k
				char l = (char) n; // converts ascii to char
				output += String.valueOf(l); // build string and cast char to string
			}
		} else if (mode == CryptMode.DECRYPT) {
			char str[] = text.toCharArray();
			for (char letter : str) { // iterates through string
				n = letter; //converts char to its ascii number
				n = shift(n, -k); //shift the letter back with -k
				char l = (char) n; // converts ascii to char
				output += String.valueOf(l); // build string and cast char to string
			}

		}
		return output;
	}

	/**
	 * Shift ascii code
	 * 
	 * @param n
	 *            old ascii Code
	 * @param i
	 *            if 1 then small letter, if 2 then upper capital letter
	 * @return shiftet ascii code
	 */
	private int shift(int n, int k) {
		int result = 0;
		if (n <= 90 && n >= 65) {
			result = (n - 65 + k);
			result = (result % 26 + 26) % 26; // Mathematisches Modulu damit
												// auch negativ geht
			result += 65;
		} else if (n <= 122 && n >= 97) {
			result = (n - 97 + k);
			result = (result % 26 + 26) % 26; // Mathematisches Modulu damit
												// auch negativ geht
			result += 97;
		} else
			result = n;
		return result;
	}

}
