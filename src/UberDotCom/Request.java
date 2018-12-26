package UberDotCom;

public class Request {

	private String source;
	private String destination;
	
	Request(String source, String destination)
	{
		this.source = source;
		this.destination = destination;
	}
	
	String getDestination()
	{
		return this.destination;
	}
	
	String getSource()
	{
		return this.source;
	}
}
