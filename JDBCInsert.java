import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsert {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatraining","root","root");
			Statement stmt = connection.createStatement();
			Scanner input = new Scanner(System.in);
			System.out.println("Enter Product ID : ");
			int pid = input.nextInt();
			System.out.println("Enter Product Name : ");
			String pname = input.nextLine();
			System.out.println("Enter Product Price : ");
			double price = input.nextDouble();
			int result = stmt.executeUpdate("Insert into product values ("+pid+",'"+pname+"',"+price+")");
			if (result == 1) {
				System.out.println("Record Inserted.......");
			} 
			stmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to Load the Class ... ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database problem.....");
			e.printStackTrace();
		}
		

	}

}
