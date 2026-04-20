package ejercicio_03;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "sakila";
		String password = "123";
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		
		try(Connection con = DriverManager.getConnection(url, user, password)){
			String query = """
					select 
					        PAYMENT_DATE,
					        sum(AMOUNT)
					from payment
					group by payment_date
					order by PAYMENT_DATE asc
					""";
			try(PreparedStatement pstm = con.prepareStatement(query)){
				ResultSet result = pstm.executeQuery();
				while(result.next()) {
					System.out.println(result.getString(1) + " - " + result.getString(2));
				}
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
