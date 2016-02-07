package programming.set11.dna;

public class test {
	public static void main(String args[]) {
		String baseDNA = "AAAGGGCGGAATGAACGCGCCGGCTCTGCGACTC";
		String otherDNA = "CCCGCCTTACTTGCGCGGCCGAG";
		System.out.println(DNAMatcher.findFirstBindingPosition(baseDNA, otherDNA));
		System.out.println(baseDNA.length());

	}

}
