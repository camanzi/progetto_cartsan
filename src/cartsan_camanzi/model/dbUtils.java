package cartsan_camanzi.model;
import java.sql.*;
import java.util.ArrayList;

public class dbUtils {
	
	protected Connection dbConn;
	
	public dbUtils(String path, String usr, String psw) {
		
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
	
	/*
	 * Ritorna la quantità di ticket per cliente 
	 * ordinati in modo decrescente
	 * 
	 * */
	
	public ResultSet ticketPerCliente() {
			Statement st;
			try {
				st = dbConn.createStatement();
				ResultSet res = st.executeQuery("SELECT cliente.denominazioneCliente, COUNT(*) AS numeroTicket FROM ticket LEFT JOIN cliente ON  cliente.idCliente = ticket.clienteTicket GROUP BY cliente.idCliente");
			return res;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	
	public ResultSet topDieciClientiPerTicket() {
		Statement st;
		try {
			st = dbConn.createStatement();
			ResultSet res = st.executeQuery("SELECT cliente.denominazioneCliente, COUNT(*) AS numeroTicket FROM ticket LEFT JOIN cliente ON  cliente.idCliente = ticket.clienteTicket GROUP BY cliente.idCliente ORDER BY COUNT(*) DESC LIMIT 10");
		return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * La quantità di minuti per cliente ordinati in modo decrescente
	 * 
	 * */
	
	public ResultSet minutiPerCliente() {
		ResultSet res;
		try {
			Statement st = dbConn.createStatement();
			res = st.executeQuery("SELECT cliente.denominazioneCliente, SUM(tempoRispostaTicket) AS minutiTotali FROM ticket LEFT JOIN cliente ON cliente.idCliente = ticket.clienteTicket GROUP BY cliente.idCliente");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return res;
	}
	
	public ResultSet topDieciClientiPerMinuti() {
		ResultSet res;
		try {
			Statement st = dbConn.createStatement();
			res = st.executeQuery("SELECT cliente.denominazioneCliente, SUM(tempoRispostaTicket) AS minutiTotali FROM ticket LEFT JOIN cliente ON cliente.idCliente = ticket.clienteTicket GROUP BY cliente.idCliente ORDER BY minutiTotali DESC LIMIT 10");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return res;
	}
	
	public ResultSet minutiPerClientePerMese(int id) {
			ResultSet res;
			try {
				Statement st = dbConn.createStatement();
				res = st.executeQuery(" SELECT cliente.denominazioneCliente, MONTH(dataTicket) AS mese ,SUM(tempoRispostaTicket) AS minutiTotali FROM ticket LEFT JOIN cliente ON cliente.idCliente = ticket.clienteTickeT WHERE cliente.idCliente = " + id + " GROUP BY MONTH(dataTicket) ORDER BY MONTH(dataTicket)");
				return res;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	
}
