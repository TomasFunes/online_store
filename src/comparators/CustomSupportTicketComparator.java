package comparators;

import java.util.Comparator;

import entities.SupportTicket;

public class CustomSupportTicketComparator implements Comparator<SupportTicket>{
	
	public int compare(SupportTicket supportTicket1, SupportTicket supportTicket2) {
		return (supportTicket1.getPriority().compareTo(supportTicket2.getPriority()) != 0)?
				supportTicket1.getPriority().compareTo(supportTicket2.getPriority()) :
					supportTicket1.getSequentialNumber() == supportTicket2.getSequentialNumber()?
							0 : supportTicket1.getSequentialNumber() > supportTicket2.getSequentialNumber()?
									1 : -1;
	}
}
