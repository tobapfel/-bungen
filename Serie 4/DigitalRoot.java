import acm.program.ConsoleProgram;

public class DigitalRoot extends ConsoleProgram {
	public void run(){
		int n = readInt ("Enter a positive Number: ");
		int dr = 0;
		int ds = 0;
		if (n < 0){
			println ("Error");
		}
		else {
			do {
				dr = 0;
					while(n>0){
					dr += n % 10;
					n /= 10;
					}
			 if (dr<10 && dr>0){
				 break;
			 }
			 else  {
				 n = dr;
				 dr/=10;
			 }
			} while (dr>0);
				println ("The digital root is: " + dr);
		}
	}
}
	


