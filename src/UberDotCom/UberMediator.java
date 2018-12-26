package UberDotCom;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UberMediator 
{
	private List<Users> listOfUsers;
	private List<Drivers> listOfDrivers;
	private static UberMediator uberInstance = new UberMediator();
	
	private UberMediator()
	{
		listOfUsers = new ArrayList<Users>();
		listOfDrivers = new ArrayList<Drivers>();
	}

	
	public static UberMediator getInstance() {
		return uberInstance;
	}
	
	public void registerInUber(Person person)
	{
		if(person instanceof Users)
		{
		   System.out.println("Registered the user\n");
		   listOfUsers.add((Users)person);
		}
		else if(person instanceof Drivers)
		{
			System.out.println("Registered the driver: " + person.getName() +"\n");
			listOfDrivers.add((Drivers) person);
		}
	}
	
	
	public Person requestMade(Person person, Request request)
	{
		return broadCastRequest(request);
	}
	
	
	public Person broadCastRequest(Request request)
	{
		System.out.print("Broadcasting the request to all the drivers: ");
	
		List<Drivers> servingDrivers = listOfDrivers.stream()
		        .filter(driver -> driver.receiveRequest(request)).collect(Collectors.toList());
		
		System.out.print("\n" + servingDrivers.size() + " drivers found for " + request.getDestination() + " : ");
		
		servingDrivers.stream().forEach(s -> System.out.print(s.getName() + " | "));
		
		Optional<Drivers> selectedDriver = servingDrivers.stream().findAny();
		
		if(selectedDriver.isPresent())
		{
			return selectedDriver.get();
		}
		
		return selectedDriver.orElse(null);
	}
	

}
