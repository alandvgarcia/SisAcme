package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBD {
	
	String nomeBanco = "sisacme_web";
	String url = "jdbc:mysql://localhost:3306/"+nomeBanco;
	String user = "root";
	String password = "admin";
	
	public Connection getConection()
	{
		
		try {
			System.out.print("Conectado!");
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
