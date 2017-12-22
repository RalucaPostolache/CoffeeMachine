package coffeeMachine;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CoffeeMachineClass extends StateMachine{

	public HashMap<String,HashMap<String,String>> table;
	public String currentState;
	public List<String> coffeeList;
	
	public CoffeeMachineClass() {
		currentState="0";
		table=getCoffeeTable();
		coffeeList=getCoffeeList();
	}
	
	private HashMap<String,HashMap<String,String>> getCoffeeTable(){
		HashMap<String,HashMap<String,String>> tempTable=new HashMap<>();
		HashMap<String,String> nextTransition = new HashMap<>();
		
		nextTransition.put("5", "5");
		nextTransition.put("10","10");
		tempTable.put("0", nextTransition);
		
		nextTransition=new HashMap<>();
		nextTransition.put("5", "10");
		nextTransition.put("10","15");
		tempTable.put("5", nextTransition);
		
		nextTransition=new HashMap<>();
		nextTransition.put("5", "15");
		nextTransition.put("Cafea10","0");
		tempTable.put("10", nextTransition);
		
		nextTransition=new HashMap<>();
		nextTransition.put("Cafea15", "0");
		nextTransition.put("Cafea10","5");
		tempTable.put("15", nextTransition);
		return tempTable;
	}
	
	private List<String> getCoffeeList() {

		List<String> coffeeList = new ArrayList<String>();
		coffeeList.add("Cafea10");
		coffeeList.add("Cafea15");
		return coffeeList;
	}

	@Override
	public void transition(String action) {
		if (table.get(currentState).get(action) != null) {
			currentState = table.get(currentState).get(action);
			if(coffeeList.contains(action)){
				System.out.println("Se prepara " + action);
			}
			System.out.println("Aveti " + currentState + " ron");
		} else {
			System.out.println("Introduceti bancnote de 5 sau 10 ron");
		}
}
	
}
