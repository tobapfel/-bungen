import acm.program.ConsoleProgram;

public class TemperatureConverter extends ConsoleProgram {
	public void run() {
		double c, F;
		println ("What do you want me to do?");
		println ("(1) Convert Celsius to Fahrenheit");
		println ("(2) Convert Fahrenheit to Celsius");
		int mode = readInt ("Mode: ");
		if (mode==1){
			c = readDouble ("Temperatur: ");
			F = c*1.8+32;
			println (F);
		}
		else if (mode==2){
			F = readDouble ("Temperatur: ");
			c = (double) (F-32)/1.8;
			println (c);
		}
	}

}
