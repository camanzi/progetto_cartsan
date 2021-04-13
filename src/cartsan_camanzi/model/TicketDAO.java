package cartsan_camanzi.model;
import java.sql.Connection;
import java.util.List;

public interface TicketDAO {
	
	public List<Ticket> ticketPerMesePerCliente(Connection dbConn, int idTicket);

}
