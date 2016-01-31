import acm.program.ConsoleProgram;

public class Fibonacci extends ConsoleProgram {
	public void run(){
		double n1 = 1;
		double n2 = 1;
		double n3;
		double n = readInt ("enter the number of outputs:");
		if (n<0){
			println ("Error");
			
		}
		else {
		println ("1");
		println ("1");
		n-=2;
		for(double i = n;i>0;i--){
			n3 = n1 + n2;
			
			n1 = n2;
			n2 = n3;
			println (n3);
		}
		}
	}

}
