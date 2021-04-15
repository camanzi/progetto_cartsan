package db.manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import db.daoimplementation.ClienteDAOIm;
import db.daoimplementation.TicketDAOIm;
import model.Cliente;
import model.Ticket;

public class DBManager {

	protected Connection dbConn;

	public DBManager(String path, String usr, String psw) {

		try {
			dbConn = DriverManager.getConnection("jdbc:mysql://" + path + "/test?" + "user=" + usr + "&password=" + psw);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void closeConn() throws SQLException {
		if(dbConn != null) {
			dbConn.close();
		}
	}

	public LinkedList<Cliente> ticketPerCliente() {
		ClienteDAOIm cliente = new ClienteDAOIm();
		return cliente.quantitaTicketPerCliente(dbConn);
	}

	public LinkedList<Cliente> topDieciClientiPerTicket() {
		ClienteDAOIm cliente = new ClienteDAOIm();
		return cliente.topDieciClientiPerTicket(dbConn);
	}

	public LinkedList<Cliente> minutiPerCliente() {
		ClienteDAOIm cliente = new ClienteDAOIm();
		return cliente.quantitaMinutiPerCliente(dbConn);
	}

	public LinkedList<Cliente> topDieciClientiPerMinuti() {
		ClienteDAOIm cliente = new ClienteDAOIm();
		return cliente.topDieciMinutiPerCliente(dbConn);
	}

	public LinkedList<Ticket> minutiPerClientePerMese(int id) {
		TicketDAOIm ticket = new TicketDAOIm();
		return ticket.ticketPerMesePerCliente(dbConn,id);
	}

}
