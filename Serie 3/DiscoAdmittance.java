import acm.program.DialogProgram;

public class DiscoAdmittance extends DialogProgram {
	public void run(){
		int minAge = readInt ("Minimum allowed age: ");
		int maxAge = readInt ("Maximum allowed age: ");
		int age = readInt ("Customer age: ");
		
		boolean wubbel = age >= minAge && age<=maxAge;
		println(wubbel);
//		if (age >= minAge && age<=maxAge ){
//			println ("true");
//		}
//		else {
//			println ("false");
//		}
	}

}
