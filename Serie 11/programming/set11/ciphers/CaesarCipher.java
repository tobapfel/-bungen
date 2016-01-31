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
		int n = 0;
		String output = "";
		if (mode == CryptMode.ENCRYPT) {
			char str[] = text.toCharArray();
			for (char letter : str) {
				n = letter;
				n = shift(n, k);
				char l = (char) n;
				output += String.valueOf(l);
			}
		} else if (mode == CryptMode.DECRYPT) {
			char str[] = text.toCharArray();
			for (char letter : str) {
				n = letter;
				n = shift(n, -k);
				char l = (char) n;
				output += String.valueOf(l);
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
