package programming.set9.morses;

import acm.program.ConsoleProgram;
import static programming.set9.morses.MorseCoder.encode;
import static programming.set9.morses.MorseCoder.decode;

public class test extends ConsoleProgram {
	public void run() {
		int n = 0;
		while (n != 3) {
			n = readInt("1: Encode\n2: Decode\n");
			if (n == 1) {
				String input = readLine("Text: ");
				String va = encode(input);
				println(va);

			} else {
				String input = readLine("Code: ");
				String c = readLine ("continue? y/n");
				while (c.equals("y")) {
					input += "\n";
					input += readLine();
					c = readLine ("continue? y/n");
				}
				//String input = ("- .... --- ..-\n... .... .- .-.. -\n-. --- -\n.--. .-. --- -.. ..- -.-. .\n-... ..- --. ...");
				println(decode(input));
			}
			n = readInt ("Exit? Y:3, N:" + n);
		}
		System.exit(0);
	}
	
}
