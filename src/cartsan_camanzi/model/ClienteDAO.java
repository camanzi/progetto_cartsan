package cartsan_camanzi.model;
import java.sql.Connection;
import java.util.List;

public interface ClienteDAO {
	
	public List<Cliente> QuantitaTicketPerCliente(Connection dbConn);
	public List<Cliente> topDieciClientiPerTicket(Connection dbConn);
	public List<Cliente> QuantitaMinutiPerCliente(Connection dbConn);
	public List<Cliente> TopDieciMinutiPerCliente(Connection dbConn);
}
