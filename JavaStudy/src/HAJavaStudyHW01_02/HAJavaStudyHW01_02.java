package HAJavaStudyHW01_02;
import java.util.*;

class HAJavaStudyHW01_02 {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in); // for input number -> make buffer.
		Fibonacci r = new Fibonacci(); // make Fibonacci class.
		
		try {
		int input = s.nextInt(); // get integer. if value is not integer -> send error message automatic.
		System.out.println(r.ReturnFib(input));
		 }catch(FibInputException e) { // if FibInputException detected, send err message.
	            System.err.println("Input Error. Please input bigger than -1.");
	     }
		
		s.close(); // close buffer.
	}
}
class Fibonacci{
	public int ReturnFib(int i) throws FibInputException{ // return integer or throw FibInputException.
		
		if(i <= 0) // FibInputException: i != Natural number, throw exception.
			throw new FibInputException(); // by FibInputException.java.
		else if(i == 1 || i == 2) // ReturnFib(1) = ReturnFib(2) = 1;
			return 1; 
		else // recursive method.
			return ReturnFib(i - 1) + ReturnFib(i - 2); 
		 
	}
}
