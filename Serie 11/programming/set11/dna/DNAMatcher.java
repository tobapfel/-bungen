package programming.set11.dna;

public class DNAMatcher {

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
		if (!(checkDNA(baseDNA) && checkDNA(candidateDNA)))
			return -1;
		String complement = convertToComplement(candidateDNA);
		int l = complement.length();
		int i = 0;
		while (baseDNA.length() >= l) {
			String subDNA = baseDNA.substring(0, l - 1);
			if (subDNA.equals(complement))
				return i;
			i += 1;
			baseDNA = baseDNA.substring(1);
		}
		return -1;
	}

	private static String convertToComplement(String dna) {
		String output = "";
		char str[] = dna.toCharArray();
		for (char letter : str) {
			switch (letter) {
			case 'A':
				output += "T";
				break;
			case 'C':
				output += "G";
				break;
			case 'G':
				output += "G";
				break;
			case 'T':
				output += "A";
				break;
			}
		}
		return output;
	}

	private static boolean checkDNA(String dna) {
		char str[] = dna.toCharArray();
		for (char letter : str) {
			if (!(letter == 'A' || letter == 'C' || letter == 'G' || letter == 'T'))
				return false;
		}
		return true;
	}

}
