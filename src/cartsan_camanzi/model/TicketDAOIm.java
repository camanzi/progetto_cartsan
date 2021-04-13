package cartsan_camanzi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TicketDAOIm implements TicketDAO{

	@Override
	public LinkedList<Ticket> ticketPerMesePerCliente(Connection dbConn, int id) {
		try {
			PreparedStatement st = dbConn.prepareStatement("SELECT ticket.clienteTicket, MONTH(dataTicket) AS mese ,SUM(tempoRispostaTicket) AS minutiTotali FROM ticket LEFT JOIN cliente ON cliente.idCliente = ticket.clienteTickeT WHERE cliente.idCliente = ? GROUP BY MONTH(dataTicket) ORDER BY MONTH(dataTicket)");
			st.setInt(1, id);
			ResultSet res = st.executeQuery();
			LinkedList<Ticket> list = new LinkedList<>();
			while(res.next()) {
				Ticket tc = new Ticket();
				tc.setClienteTicket(res.getInt("clienteTicket"));
				tc.setMeseTicket(res.getInt("mese"));
				tc.setMinutiTotali(res.getInt("minutiTotali"));
				list.add(tc);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


}
