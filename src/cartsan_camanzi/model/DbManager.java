package cartsan_camanzi.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

	protected Connection dbConn;

	public DbManager(String path, String usr, String psw) {

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
			PreparedStatement st = dbConn.prepareStatement("SELECT cliente.denominazioneCliente, MONTH(dataTicket) AS mese ,SUM(tempoRispostaTicket) AS minutiTotali FROM ticket LEFT JOIN cliente ON cliente.idCliente = ticket.clienteTickeT WHERE cliente.idCliente = ? GROUP BY MONTH(dataTicket) ORDER BY MONTH(dataTicket)");
			st.setInt(1, id);
			res = st.executeQuery();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
