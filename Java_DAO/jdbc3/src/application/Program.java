package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection(); 
			
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES "
					+ "(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			//Inserção de dados no DB
			st.setString(1,"Carl Purple");
			st.setString(2,"CarlPurple@gmail.com");
			st.setDate(3,new java.sql.Date(sdf.parse("01/02/2000").getTime()));
			st.setDouble(4,2000.00);
			st.setInt(5,4);
			
			int rowsAffected = st.executeUpdate();
			
			//Mensagem de alteração no banco
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				//Retorna o ID do novo vendedor
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = "+ id);
				}
			}
			else {
				System.out.println("No rows affected!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}
}
