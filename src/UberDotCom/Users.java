package UberDotCom;

public class Users extends Person {
	
	public Users(UberMediator mediator)
	{
		this.ubermediator = mediator;
	}
	
	public void registerForUber()
	{
		ubermediator.registerInUber(this);
	}
	
	public void searchCab(Request request)
	{
		System.out.println("\nUser is requesting for a cab to " + request.getDestination() +  " from Syracuse\n");
		System.out.println("Request created" + "\nSource:" + request.getSource() + "\nDestination: "+ request.getDestination() +"\n");
		
		
		Person driver = ubermediator.requestMade(this, request);
		
		if(driver != null)
		{
			System.out.println("\n\nDriver who will be serving: " + driver.getName() );
		}
		
		else {
			System.out.println("\n\nNo driving serving this location");
		}
	}
	
	
}
