package view;

import model.Cliente;
import model.Ticket;

public class View {

	public void showCliente(Cliente cl) {
		System.out.print("Denominazione cliente = " + cl.getDenominazioneCliente() + " Numero Ticket = " + cl.getNumeroTicket() + " Minuti totali = "+ cl.getNumeroMinuti());
		System.out.println();
	}
	
	public void showTicket(Ticket tc) {
		System.out.print("Id cliente = " + tc.getClienteTicket() + " Mese = " + tc.getMeseTicket() + " Minuti totali = "+ tc.getMinutiTotali());
		System.out.println();
	}

	public void errore() {
		System.out.print("Input sbagliato riprovare");
	}

	public void showOption() {
		System.out.println("\nScegliere cosa vedere:\n"
				+ " 1:Numero_ticket_cliente\n"
				+ " 2:Numero_minuti_cliente\n"
				+ " 3:Top_dieci_clienti_minuti\n"
				+ " 4:Top_dieci_clienti_ticket\n"
				+ " 5:Minuti_per_cliente\n"
				+ " 9:Exit");
	}

	public void inserisciId() {
		System.out.print("Inserire id:");
	}

}
