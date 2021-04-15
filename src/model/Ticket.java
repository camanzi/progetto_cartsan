package model;

public class Ticket {

	/*
	 * si noti che questo non è considerabile come un singolo ticket
	 * ma rappresenta un insieme di ticket di un certo mese dato un certo cliente
	 * 
	 * */
	
	private int mese;
	private int clienteTicket;
	private int minutiTotali;

	public int getMeseTicket() {
		return mese;
	}

	public void setMeseTicket(int mese) {
		this.mese = mese;
	}

	public int getClienteTicket() {
		return clienteTicket;
	}

	public void setClienteTicket(int clienteTicket) {
		this.clienteTicket = clienteTicket;
	}

	public int getMinutiTotali() {
		return minutiTotali;
	}

	public void setMinutiTotali(int minutiTotali) {
		this.minutiTotali = minutiTotali;
	} 

}
