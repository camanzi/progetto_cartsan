package cartsan_camanzi.model;
import java.util.List;

public interface ClienteDAO {
	
	public List<Cliente> clientiPerTicket(int idTicket);
	public void updateCliente(Cliente t, int idTicket);
	public void createCliente(Cliente t);
	public void deleteCliente(int idTicket);
}
