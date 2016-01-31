package programming.set7.date;
import acm.program.ConsoleProgram;
import programming.set7.date.*;

public class test extends ConsoleProgram {
	public void run(){
		boolean b = true;
		for (int i = 0; i<10; i++){
			if (i == 5){
				b = b && false;
			}
			else {
				b = b && true;
			}
		println (b);
		}
	}
	
}
