package cartsan_camanzi.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ClienteDAOIm implements ClienteDAO{


	/*
	 * NB Non gestisco l'eccezione di SQL quindi possibili NullPointer Ex
	 * 
	 * */

	@Override
	public LinkedList<Cliente> QuantitaTicketPerCliente(Connection dbConn) {
		LinkedList<Cliente> list = new LinkedList<>();
		try {
			Statement st = dbConn.createStatement();
			ResultSet res = st.executeQuery("SELECT cliente.denominazioneCliente, COUNT(*) AS numeroTicket FROM ticket LEFT JOIN cliente ON  cliente.idCliente = ticket.clienteTicket GROUP BY cliente.idCliente");
			while(res.next()) {
				Cliente cl = new Cliente();
				cl.setDenominazioneCliente(res.getString("denominazioneCliente"));
				cl.setNumeroTicket(res.getInt("numeroTicket"));
				list.add(cl);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public LinkedList<Cliente> topDieciClientiPerTicket(Connection dbConn) {
		try {
			Statement st = dbConn.createStatement();
			ResultSet res = st.executeQuery("SELECT cliente.denominazioneCliente, COUNT(*) AS numeroTicket FROM ticket LEFT JOIN cliente ON  cliente.idCliente = ticket.clienteTicket GROUP BY cliente.idCliente ORDER BY COUNT(*) DESC LIMIT 10");
			LinkedList<Cliente> list = new LinkedList<>();
			while(res.next()) {
				Cliente cl = new Cliente();
				cl.setDenominazioneCliente(res.getString("denominazioneCliente"));
				cl.setNumeroTicket(res.getInt("numeroTicket"));
				list.add(cl);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public LinkedList<Cliente> QuantitaMinutiPerCliente(Connection dbConn) {
		try {
			Statement st = dbConn.createStatement();
			ResultSet res = st.executeQuery("SELECT cliente.denominazioneCliente, SUM(tempoRispostaTicket) AS minutiTotali FROM ticket LEFT JOIN cliente ON cliente.idCliente = ticket.clienteTicket GROUP BY cliente.idCliente");
			LinkedList<Cliente> list = new LinkedList<>();
			while(res.next()) {
				Cliente cl = new Cliente();
				cl.setDenominazioneCliente(res.getString("denominazioneCliente"));
				cl.setNumeroMinuti(res.getInt("minutiTotali"));
				list.add(cl);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public LinkedList<Cliente> TopDieciMinutiPerCliente(Connection dbConn) {
		try {
			Statement st = dbConn.createStatement();
			ResultSet res= st.executeQuery("SELECT cliente.denominazioneCliente, SUM(tempoRispostaTicket) AS minutiTotali FROM ticket LEFT JOIN cliente ON cliente.idCliente = ticket.clienteTicket GROUP BY cliente.idCliente ORDER BY minutiTotali DESC LIMIT 10");
			LinkedList<Cliente> list = new LinkedList<>();
			while(res.next()) {
				Cliente cl = new Cliente();
				cl.setDenominazioneCliente(res.getString("denominazioneCliente"));
				cl.setNumeroMinuti(res.getInt("minutiTotali"));
				list.add(cl);
			}
			return list;
		} catch (SQLException ex) {	
			ex.printStackTrace();
			return null;

		}
	}
}
