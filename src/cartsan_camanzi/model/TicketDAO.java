package cartsan_camanzi.model;
import java.util.List;

public interface TicketDAO {
	
	public List<Ticket> readTicket(int idTicket);

	public void updateTicket(Ticket t, int idTicket);

	public void createTicket(Ticket t);

	public void deleteTicket(int idTicket);

}
