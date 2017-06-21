package nl.hu.ipass.project.persistence;

import nl.hu.ipass.project.webservices.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends BaseDAO {
	public Student saveStudent(Student st) throws SQLException {
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO student (email, voornaam, achternaam, wachtwoord, rol, groepsnaam) VALUES (?,?,?,?,?,?)");
		
		stmt.setString(1, st.getEmail());
		stmt.setString(2, st.getVoornaam());
		stmt.setString(3, st.getAchternaam());
		stmt.setString(4, st.getWachtwoord());
		stmt.setString(5, st.getRol());
		stmt.setString(6, st.getGroepsnaam());
		
		stmt.executeUpdate();
		stmt.close();
		con.close();
		return st;
	}
	
	public List<Student> vindAlleStudenten(String groep) throws SQLException {
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
				"SELECT * FROM student WHERE groepsnaam = '" +groep+"'");
		ResultSet rs = stmt.executeQuery();
		List<Student> studentenLijst = new ArrayList<Student>();
		
		while (rs.next()){
		
			String email = rs.getString("email");
			String voornaam = rs.getString("voornaam");
			String achternaam = rs.getString("achternaam");
			String wachtwoord = rs.getString("wachtwoord");
			String rol = rs.getString("rol");
			String gn = rs.getString("groepsnaam");
			
			Student stu = new Student(email, voornaam, achternaam, wachtwoord, rol, gn);
			studentenLijst.add(stu);
		}
		rs.close();
		stmt.close();
		con.close();
		return studentenLijst;
	}

}
