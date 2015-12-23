import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExampleWithMySql {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		Connection con = null;
		// jdbc:mysql://ipaddressORhostname:portnumber/db name
		String dbUrl = "jdbc:mysql://localhost:3306/seleniumexcercise";

		String dbUser = "root";
		String dbPass = "";
		String dbQuery = "select * from seleniumexcercise.logininfo";

		// Load mysql jdbc driver
		// Class.forName("com.mysql.jdbc.driver"); // No need for jdk8

		// Create connection
		con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

		// Create Statement Object
		Statement statement = con.createStatement();

		// Execute SQL Query and store data into result set
		ResultSet result = statement.executeQuery(dbQuery);

// EXAMPLE 1
// ==============================================================================================

		System.out
				.println("Retrieve username and password using column level:");
		System.out.println("username ------ password");
		// While loop to iterate data
		while (result.next()) {
			String username = result.getString("username");
			String password = result.getString("password");
			System.out.println(username + " ------ " + password);
		}

// ================================================================================================
// EXAMPLE 2
		// Moves the cursor to the front of this ResultSet object
		result.beforeFirst();

		System.out
				.println("\n\nRetrieve username and password using column index:");
		System.out.println("username ------ password");
		// While loop to iterate data
		while (result.next()) {
			String username = result.getString(1);
			String password = result.getString(2);
			System.out.println(username + " ------ " + password);
		}

// =================================================================================================
// EXAMPLE 3
// Copy and print data into String array
		String data[][] = new String[2][2]; // database contain 2 rows and 2
											// columns
		int i = 0; // for row

		// Moves the cursor to the front of this ResultSet object
		result.beforeFirst();
		// Copy from database to data array
		while (result.next()) {
			// j for column
			for (int j = 0; j < 2; j++) {
				data[i][j] = result.getString(j + 1);
			}

			i++;
		}

		// Print the data array
		System.out.println("\n\nPrint data String array:\nnusername\tpassword");
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data.length; y++) {
				System.out.print(data[x][y] + "\t");
			}
			System.out.println();
		}

// =================================================================================================

		// Closing Database connection
		con.close();

	}

}
