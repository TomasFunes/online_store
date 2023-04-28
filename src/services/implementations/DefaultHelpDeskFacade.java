package services.implementations;
import services.HelpDeskFacade;
import java.util.Queue;
import java.util.PriorityQueue;
import entities.SupportTicket;
import comparators.CustomSupportTicketComparator;

public class DefaultHelpDeskFacade implements HelpDeskFacade {
	
	Queue<SupportTicket> supportTickets = new PriorityQueue<>(new CustomSupportTicketComparator());
	
	public void addNewSupportTicket(SupportTicket supportTicket) {
		supportTickets.offer(supportTicket);
	}
	
	public SupportTicket getNextSupportTicket() {
		return supportTickets.poll();
	}
	
	public int getNumberOfTickets() {
		return supportTickets.size();
	}
}
