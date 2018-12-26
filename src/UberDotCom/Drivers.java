package UberDotCom;

import java.util.*;

public class Drivers extends Person {
	
	private List<String> listofDestinations = new ArrayList<String>();
	
	public Drivers(UberMediator ubermediator, String nameOfDriver ,List<String> listDestinations)
	{
		this.ubermediator = ubermediator;
		this.name = nameOfDriver;
		this.listofDestinations = listDestinations;
	}
	
	public void registerForUber()
	{
		ubermediator.registerInUber(this);
	}
	
	
	public boolean receiveRequest(Request request)
	{
		String destination = request.getDestination();
		
		boolean flag = listofDestinations.stream().anyMatch(s -> s.equals(destination));
		
		return flag;
	}
	
}
