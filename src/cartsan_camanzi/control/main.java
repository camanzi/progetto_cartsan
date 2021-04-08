package cartsan_camanzi.control;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import cartsan_camanzi.model.dbUtils;
import cartsan_camanzi.view.View;

public class main {

	public static void main(String[] args) {
		dbUtils db = new dbUtils("", "", "");
		View v = new View();
		Scanner s = new Scanner(System.in);
		ResultSet res = null;
		int input;
		
		/*
		 * TicketXCliente = Top10ClientiXTicket
		 * 
		 * MinutiXCliente = Top10minutiPerCliente
		 * 
		 * MinutiXMeseXCliente
		 * 
		 * */
		
		try {
			do {
				v.showOption();
				input = s.nextInt();
				switch (input){
					case 1:
						res  = db.ticketPerCliente();
						v.showResult(res);
					break;
					case 2:
						res  = db.minutiPerCliente();
						v.showResult(res);
						break;
					case 3:
						res  = db.topDieciClientiPerMinuti();
						v.showResult(res);
						break;
					case 4:
						res  = db.topDieciClientiPerTicket();
						v.showResult(res);
						break;
					case 5:
						v.inserisciId();
						int id = s.nextInt();
						res  = db.minutiPerClientePerMese(id);
						v.showResult(res);
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
