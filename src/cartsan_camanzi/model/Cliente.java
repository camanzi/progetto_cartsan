package cartsan_camanzi.model;

public class Cliente {

	private String denominazioneCliente;
	private int numeroTicket;
	private int numeroMinuti;

	public Cliente() {
		this.denominazioneCliente = "";
		this.numeroMinuti = 0;
		this.numeroTicket = 0;
	}

	public String getDenominazioneCliente() {
		return denominazioneCliente;
	}
	public void setDenominazioneCliente(String denominazioneCliente) {
		this.denominazioneCliente = denominazioneCliente;
	}
	public int getNumeroTicket() {
		return numeroTicket;
	}
	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}
	public int getNumeroMinuti() {
		return numeroMinuti;
	}
	public void setNumeroMinuti(int numeroMinuti) {
		this.numeroMinuti = numeroMinuti;
	}

}
