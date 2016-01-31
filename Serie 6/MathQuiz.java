import acm.program.ConsoleProgram;
import java.lang.Object;
import java.util.Random;

public class MathQuiz extends ConsoleProgram {
	/**
	 * Checks whether the given result is really the result of the operation on
	 * the two operands.
	 * 
	 * @param operand1
	 *            the first operand.
	 * @param operator
	 *            the operator, given as a String. This must be either
	 *            {@code "+"} or {@code "-"}. Otherwise, this method will always
	 *            return {@code false}.
	 * @param operand2
	 *            the second operand.
	 * @param result
	 *            the proposed result.
	 * @return {@code true} if {@code result} is really the result of the
	 *         calculation, {@code false} otherwise.
	 */
	public boolean isCorrect(int operand1, String operator, int operand2, int result) {
		int Result = 0;
		switch (operator) { 
		case "+":
			Result = operand1 + operand2;
			break;
		case "-":
			Result = operand1 - operand2;
			break;
		}
		return (result == Result);
	}

	/**
	 * Return the result of the given operation on the two operands.
	 * 
	 * @param operand1
	 *            the first operand.
	 * @param operator
	 *            the operator, given as a String. This must be either
	 *            {@code "+"} or {@code "-"}. Otherwise, this method will always
	 *            return {@code false}.
	 * @param operand2
	 *            the second operand.
	 * @return result
	 */
	public int result(int operand1, String operator, int operand2) {
		int Result = 0;
		switch (operator) {
		case "+":
			Result = operand1 + operand2;
			break;
		case "-":
			Result = operand1 - operand2;
			break;
		}
		return Result;
	}

	/**
	 * Returns a message that can be displayed to the user after successfully
	 * solving a problem. There are at least four messages the method randomly
	 * chooses from to keep it interesting.
	 * 
	 * @return randomly selected success message.
	 */
	private String generateSuccessMessage() {
		Random rn = new Random();
		String print = "";
		switch (rn.nextInt(4)){
		case 0:
			print = "correct";
			break;
		case 1:
			print = ":)";
			break;
		case 2:
			print = "right answer";
			break;
		case 3:
			print = "true";
			break;
		}
		return print;
	}

	/**
	 * Returns a message that can be displayed to the user after failing to
	 * solve a problem correctly. There are at least four messages the method
	 * randomly chooses from to keep it interesting. The correct result is
	 * included in the message somewhere to teach the user a lesson.
	 * 
	 * @param correctResult
	 *            the number that would have been the correct result. This
	 *            number is included somehow in the returned messsage.
	 * @return randomly selected fail message.
	 */
	private String generateFailMessage(int correctResult) {
		Random rn = new Random();
		String print = "";
		switch (rn.nextInt(4)) {
		case 0:
			print = "wrong! correct was: " + correctResult;
			break;
		case 1:
			print = ":( correct was: " + correctResult;
			break;
		case 2:
			print = "wrong answer! correct was: " + correctResult;
			break;
		case 3:
			print = "false! correct was: " + correctResult;
			break;
		}
		return print;
	}

	public void run() {
		println("M A T H  -  Q U I Z");
		int operand1, operand2, operator, Result;
		String op = "";
		for (int i = 0; i < 5; i++) {
			do{
			Random rn = new Random();
			operand1 = rn.nextInt(21); //Eine zufällige ganze Zahl zwischen 0 und 20 (einschließlich)
			operand2 = rn.nextInt(21); //Eine zufällige ganze Zahl zwischen 0 und 20 (einschließlich)
			operator = rn.nextInt(2);  //Eine zufällige ganze Zahl zwischen 0 und 1 (einschließlich)
			switch (operator) {
			case 0:
				op = "+";
				break;
			case 1:
				op = "-";
				break;
			}
			}while (result(operand1, op, operand2)<=0);
			Result = readInt("What is " + operand1 + op + operand2 + "? ");
			if (isCorrect(operand1, op, operand2, Result)) {
				println(generateSuccessMessage());
			} else if (!(isCorrect(operand1, op, operand2, Result))) {
				println(generateFailMessage(result(operand1, op, operand2)));
			}
		}
	}

}
