import acm.program.ConsoleProgram;

public class Interest extends ConsoleProgram {
	public void run(){
		double acc;
		double air;
		double a1y;
		double a2y;
		acc = readDouble("Enter current account balance: ");
		air = readDouble ("Enter annual interest rate: ");
		a1y = (air/100)*acc;
		a1y = a1y+acc;
		a2y = (air/100)*a1y;
		a2y = a2y+a1y;
		println ("Your balance after 1 year: "+a1y);
		println ("Your blance after 2 year: "+a2y);
	}

}
