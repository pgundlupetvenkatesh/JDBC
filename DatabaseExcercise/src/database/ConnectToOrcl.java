/**
 * 
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.Test;

/**
 * @author Pratik
 *
 */
public class ConnectToOrcl {
	@Test
	public void jdbc() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cins570 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cins570", "cins570");
		Statement stmt = cins570.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employees");
		ArrayList<String> al = new ArrayList<String>();
		while(rs.next()) {
			String name = rs.getString("FIRST_NAME");
			al.add(name);
		}
		System.out.println("My first name is " + al.get(0));
	}
}
