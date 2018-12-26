package UberDotCom;

abstract class Person
{
	protected UberMediator ubermediator;
	protected String name;
	protected String contactNumber;
	protected String emailId;
	protected String address;
	
	Person()
	{
		
	}
	
	String getName()
	{
		return this.name;
	}
	
	String getContactNumber()
	{
		return this.contactNumber;
	}
	
	String getEmailId()
	{
		return this.emailId;
	}
	
	String getAddress()
	{
		return this.address;
	}
	
    abstract void registerForUber() ;
	
    void searchCab(Request request) {};
    
}
