package db.dao;
import java.sql.Connection;
import java.util.List;

import model.Ticket;

public interface TicketDAO {
	
	public List<Ticket> ticketPerMesePerCliente(Connection dbConn, int idTicket);

}
