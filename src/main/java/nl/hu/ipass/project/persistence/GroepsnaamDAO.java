package nl.hu.ipass.project.persistence;

import nl.hu.ipass.project.webservices.Groepsnaam;
import java.sql.*;

public class GroepsnaamDAO extends BaseDAO {
	public Groepsnaam saveGroepsnaam(Groepsnaam gn) throws SQLException {
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO groep (groepsnaam) VALUES (?)");
		
		stmt.setString(1, gn.getGroepsnaam());		
		stmt.executeUpdate();
		con.close();
		return gn;
	}
	
}
