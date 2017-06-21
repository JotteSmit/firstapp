package nl.hu.ipass.project.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends BaseDAO {
	public String findRoleForUsernameAndPassword(String email, String wachtwoord, String groepsnaam) {
		String rol = null;
		String query = "SELECT rol FROM student WHERE email = ? AND wachtwoord = ? AND groepsnaam = ?";
		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, wachtwoord);
			pstmt.setString(3, groepsnaam);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next())
				rol = rs.getString("rol");
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rol;
	}
}