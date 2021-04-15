package db.dao;
import java.sql.Connection;
import java.util.List;

import model.Ticket;

public interface TicketDAO {
	
	/*
	 * @return una lista con mese e minuti
	 * i minuti rappresentano quanti minuti ha occupato  il cliente
	 * il mese è il mese a cui fanno riferimento i minuti
	 * 
	 * */
	
	public List<Ticket> ticketPerMesePerCliente(Connection dbConn, int idTicket);

}
