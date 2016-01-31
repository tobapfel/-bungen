import acm.program.ConsoleProgram;

public class BoundsChecking extends ConsoleProgram {
	/**
	 * Checks if the given number is within the given bounds (inclusive).
	 * 
	 * @param n
	 *            the number to check.
	 * @param lower
	 *            the lower bound.
	 * @param upper
	 *            the upper bounds.
	 * @return {@code true} if the number is within the bounds, {@code false} if
	 *         it isn't or if the bounds are invalid (@code upper < lower}.
	 */
	public boolean isValid(int n, int lower, int upper) {
	    if (upper < lower){
	    	return false;
	    }
	    else if (n >= lower && n <= upper){
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	/**
	 * Reads an integer from the console and only accepts it if it falls into
	 * the given bounds.
	 * 
	 * @param prompt
	 *            the text displayed to the user when prompting for input.
	 * @param lower
	 *            the lower accepted bound for the input.
	 * @param upper
	 *            the upper accepted bound for the input.
	 * @return a number {@code >= lower} and {@code <= upper}.
	 */
	public int readBoundedInt(String prompt, int lower, int upper) {
	    int n;
		while (true){
	    	n = readInt(prompt);
	    	if (!(isValid (n, lower, upper))){
	    		println("the number must be between "+lower+" and "+upper);
	    	}
	    	else {
	    		break;
	    	}
	    } 
	    return n;
	}
	
	public void run(){
		int lower = readInt ("Enter minimum: ");
		int upper = readInt ("Enter maximum: ");
		int m = readBoundedInt ("Enter a number", lower, upper);
		println (m);
	}
}
