package db.dao;
import java.sql.Connection;
import java.util.List;

import model.Cliente;

public interface ClienteDAO {
	
	/*
	 * @return la lista completa di clienti con affiancati il numero di ticket
	 * */
	
	public List<Cliente> quantitaTicketPerCliente(Connection dbConn);
	
	/*
	 * @return i 10 clienti con il maggior numero di ticket
	 * */
	
	public List<Cliente> topDieciClientiPerTicket(Connection dbConn);
	
	/*
	 * @return la lista completa di clienti con affiancati i minuti totali
	 * */
	
	public List<Cliente> quantitaMinutiPerCliente(Connection dbConn);
	
	/*
	 * @return i 10 clienti con il maggior numero di minuti
	 * */
	
	public List<Cliente> topDieciMinutiPerCliente(Connection dbConn);
}
