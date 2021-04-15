package db.dao;
import java.sql.Connection;
import java.util.List;

import model.Cliente;

public interface ClienteDAO {
	
	public List<Cliente> quantitaTicketPerCliente(Connection dbConn);
	public List<Cliente> topDieciClientiPerTicket(Connection dbConn);
	public List<Cliente> quantitaMinutiPerCliente(Connection dbConn);
	public List<Cliente> topDieciMinutiPerCliente(Connection dbConn);
}
