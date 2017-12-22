package coffeeMachine;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		CoffeeMachineClass coffeeMachine=new CoffeeMachineClass();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			coffeeMachine.transition(scanner.next());
		}
	}
	
}
