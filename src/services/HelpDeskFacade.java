package services;
import entities.SupportTicket;

public interface HelpDeskFacade {
	
	void addNewSupportTicket(SupportTicket supportTicket);
	SupportTicket getNextSupportTicket();
	int getNumberOfTickets();
}
