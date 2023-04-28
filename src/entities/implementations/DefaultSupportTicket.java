package entities.implementations;
import entities.RequestType;
import entities.Priority;
import entities.SupportTicket;

public class DefaultSupportTicket implements SupportTicket {
	
	private RequestType requestType;
	private int sequential_number;
	private static int NEXT_SEQUENTIAL_NUMBER = 1;
	
	public DefaultSupportTicket(RequestType requestType) {
		this.requestType = requestType;
		this.sequential_number = NEXT_SEQUENTIAL_NUMBER++;
	}
	
	public Priority getPriority() {
		return this.requestType.getPriority();
	}
	
	public int getSequentialNumber() {
		return this.sequential_number;
	}
	
	public RequestType getRequestType() {
		return this.requestType;
	}
}
