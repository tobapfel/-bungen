package programming.set8.optimus;

import acm.program.ConsoleProgram;
import java.util.ArrayList;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.InstructionTargeter;

public class SieveOfEratosthenes extends ConsoleProgram {
	ArrayList list = new ArrayList();
	
	/**
	 * removes all multiple numbers of {@code n} between {@code n}+1 and {@code maxValue} from the list
	 * @param n
	 * @param maxValue
	 */
	public void removeMultibleNumbers(int n,int maxValue){
		int m = n;
		while (m <= maxValue){
			m = n + m;
			if (list.contains((Object)m)) list.remove((Object)m);
			
		}
	}
	
	public void run() {
		int n = 0;
		do {
			n = readInt("Enter the maximum value: ");
		} while (2 >= n);
		for (int i = 2; i<=n; i++){
			list.add((Object) i);
		}
		
		for (int j = 2; j<=n; j++){
			if (list.contains((Object)j)) removeMultibleNumbers(j, n);
		}
		
		Iterator it = list.iterator();
		while (it.hasNext()){
			println (it.next());
		}
	}

}
