package cartsan_camanzi.view;

import java.sql.*;

public class View {

	public void showResult(ResultSet res) throws SQLException {
		ResultSetMetaData rsmd = res.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while(res.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = res.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
		    System.out.println("");
		}
		
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
