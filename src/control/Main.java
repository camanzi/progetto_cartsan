package control;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import db.manager.DBManager;
import model.Cliente;
import model.Ticket;
import view.View;

public class Main {

	public static void main(String[] args) {

		DBManager db = new DBManager("localhost", "kamanz", "123456");
		View v = new View();
		Scanner s = new Scanner(System.in);
		LinkedList<Cliente> listCliente;
		LinkedList<Ticket> listTicket;
		int input;

		/*
		 * Query possibili:
		 * 
		 * QuantitaTicketXCliente -> ritorno lista clienti x
		 * 
		 * Top10ClientiXTicket -> ritorno lista clienti x
		 * 
		 * MinutiXCliente -> ritorno lista clienti x
		 * 
		 * Top10minutiPerCliente -> ritorno lista clienti
		 * 
		 * MinutiXMeseXCliente -> ritorno lista ticket
		 * 
		 * */

		try {
			do {
				v.showOption();
				input = s.nextInt();
				switch (input){
				case 1:
					listCliente = db.ticketPerCliente();
					while(!listCliente.isEmpty()) {
						v.showCliente(listCliente.remove());	
					}
					break;
				case 2:
					listCliente = db.minutiPerCliente();
					while(!listCliente.isEmpty()) {
						v.showCliente(listCliente.remove());	
					}
					break;
				case 3:
					listCliente = db.topDieciClientiPerMinuti();
					while(!listCliente.isEmpty()) {
						v.showCliente(listCliente.remove());	
					}
					break;
				case 4:
					listCliente = db.topDieciClientiPerTicket();
					while(!listCliente.isEmpty()) {
						v.showCliente(listCliente.remove());	
					}
					break;
				case 5:
					v.inserisciId();
					int id = s.nextInt();
					listTicket = db.minutiPerClientePerMese(id);
					while(!listTicket.isEmpty()) {
						v.showTicket(listTicket.remove());	
					}
					break;
				case 9:
					break;
				default:
					v.errore();	
					break;
				}
			} while(input != 9); 
			db.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();

		}


	}

}
