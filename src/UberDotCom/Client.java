package UberDotCom;

import java.util.*;

public class Client {

	public static void main(String args[])
	{
		UberMediator mediator = UberMediator.getInstance();
		
		System.out.println("Registering user on Uber.com\n");
		Person user = new Users(mediator);
		user.registerForUber();
		
		System.out.println("Registering 3 drivers: John, David, Justin on Uber.com\n");
		List<String> listOfDestinations = Arrays.asList("Boston", "New York", "Niagara");
		String name = "John";
		Person driver1 = new Drivers(mediator, name, listOfDestinations);
		driver1.registerForUber();
		
		listOfDestinations = Arrays.asList("Rochester", "New York", "Niagara");
		name = "David";
		Person driver2 = new Drivers(mediator, name, listOfDestinations);
		driver2.registerForUber();
		
		listOfDestinations = Arrays.asList("Boston", "Rochester", "Albany");
		name = "Justin";
		Person driver3 = new Drivers(mediator, name, listOfDestinations);
		driver3.registerForUber();
		
		System.out.println("-------------1st request------------");
		
		String source = "Syracuse";
		String destination = "Boston";
		
		Request request = new Request(source, destination);
		
		user.searchCab(request);
		
		System.out.println("\n------------2nd request------------");
		
		destination = "California";
		
		Request request1 = new Request(source, destination);
		
		user.searchCab(request1);
	}
}
