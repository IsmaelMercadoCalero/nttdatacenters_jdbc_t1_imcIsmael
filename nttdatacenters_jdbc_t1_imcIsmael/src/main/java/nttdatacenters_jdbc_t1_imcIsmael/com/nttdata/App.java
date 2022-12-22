package nttdatacenters_jdbc_t1_imcIsmael.com.nttdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Ismael Mercado Calero
 *
 */
public class App {
	public static void main(String[] args) {
		// Conexión y ejecución de consulta a BD (MySQL).
		System.out.println("\t EMPLEADOS");
		System.out.println("______________________________________________________________________");
		stablishMDBConnectionEmployes();
		System.out.println("______________________________________________________________________");
		System.out.println("\t EMPRESAS");
		System.out.println("______________________________________________________________________");
		System.out.println();
		stablishMDBConnectionService();
		System.out.println("______________________________________________________________________");
	}

	private static void stablishMDBConnectionService() {
		try {

			// Se establece el driver de conexión a BBDD.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Apertura de conexión con BBDD (URL / Usuario / Contraseña)
			final Connection dbConnection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/nttdata_hibernate_taller1", "root", "root");

			// Realización de consulta.
			final Statement sentence2 = dbConnection.createStatement();
			final String query2 = "SELECT * from nttdata_t1mysql_services";
			final ResultSet queryResult2 = sentence2.executeQuery(query2);

			// Iteración de resultados.
			StringBuilder services = new StringBuilder();
			while (queryResult2.next()) {

				services.append("Id: ");
				services.append(queryResult2.getString("id_service"));

				services.append(" | Name: ");
				services.append(queryResult2.getString("name"));

				services.append(" | Description: ");
				services.append(queryResult2.getString("description"));

				services.append(" | Tecnologies: ");
				services.append(queryResult2.getString("tecnologies"));

				services.append(" | Agile: ");
				services.append(queryResult2.getString("isAgile"));

				services.append("\n");
			}

			System.out.println(services.toString());

			// Cierre de conexión con BBDD.
			dbConnection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Establece la conexión con base de datos MySQL.
	 */
	private static void stablishMDBConnectionEmployes() {

		try {

			// Se establece el driver de conexión a BBDD.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Apertura de conexión con BBDD (URL / Usuario / Contraseña)
			final Connection dbConnection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/nttdata_hibernate_taller1", "root", "root");

			// Realización de consulta.
			final Statement sentence = dbConnection.createStatement();
			final String query = "SELECT * from nttdata_t1mysql_employees";
			final ResultSet queryResult = sentence.executeQuery(query);

			// Iteración de resultados.
			StringBuilder employes = new StringBuilder();
			while (queryResult.next()) {

				employes.append("Id: ");
				employes.append(queryResult.getString("id_employee"));

				employes.append(" | Name: ");
				employes.append(queryResult.getString("name"));

				employes.append(" | Rol: ");
				employes.append(queryResult.getString("rol"));

				employes.append(" | id_service: ");
				employes.append(queryResult.getString("id_service"));

				employes.append("\n");
			}

			System.out.println(employes.toString());

			// Cierre de conexión con BBDD.
			dbConnection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
