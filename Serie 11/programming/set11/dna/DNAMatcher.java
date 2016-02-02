package programming.set11.dna;

public class DNAMatcher {

	private DNAMatcher() {

	}

	/**
	 * Returns the index of the first position in baseDNA where candidateDNA can
	 * bind to baseDNA, if any.
	 * 
	 * @param baseDNA
	 *            the base DNA string.
	 * @param candidateDNA
	 *            the DNA string to try to bind to the base DNA.
	 * @return index of the first binding position or {@code -1} if candidateDNA
	 *         cannot bind to baseDNA. Also returns {@code -1} if either of the
	 *         DNA strings contains characters other than A, C, G, and T.
	 */
	public static int findFirstBindingPosition(String baseDNA, String candidateDNA) {
		if (!(checkDNA(baseDNA) && checkDNA(candidateDNA))) // checks if there
															// is an unknown
															// base
			return -1;
		String complement = convertToComplement(candidateDNA);
		int l = complement.length(); // string length of canidateDNA
		int i = 0; // index
		while (baseDNA.length() >= l) { // stops when the baseDNA is shorter
										// then the canidateDNA
			String subDNA = baseDNA.substring(0, l); // builds a substring
														// to be compared
			if (subDNA.equals(complement)) // compares substring an canidateDNA
				return i;
			i += 1; // increase index
			baseDNA = baseDNA.substring(1); // builds a new string without the
											// first char of old string
		}
		return -1;
	}

	/**
	 * returns the complement dna of {@code dna}
	 * 
	 * @param dna
	 *            string that contains dna
	 * @return complement dna
	 */
	private static String convertToComplement(String dna) {
		String output = "";
		char str[] = dna.toCharArray();
		for (char letter : str) { // iterate through string
			switch (letter) {
			case 'A':
				output += "T";
				break;
			case 'C':
				output += "G";
				break;
			case 'G':
				output += "C";
				break;
			case 'T':
				output += "A";
				break;
			}
		}
		return output;
	}

	/**
	 * checks if there is an unknown base in the dna
	 * 
	 * @param dna
	 *            string that contains dna
	 * @return boolean
	 */
	private static boolean checkDNA(String dna) {
		char str[] = dna.toCharArray();
		for (char letter : str) { // iterate through string
			if (!(letter == 'A' || letter == 'C' || letter == 'G' || letter == 'T'))
				return false;
		}
		return true;
	}

}
