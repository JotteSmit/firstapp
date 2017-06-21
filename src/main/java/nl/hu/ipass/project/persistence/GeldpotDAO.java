package nl.hu.ipass.project.persistence;

import nl.hu.ipass.project.webservices.Geldpot;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeldpotDAO extends BaseDAO {
	public Geldpot saveWeekbedrag(Geldpot gp) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO geldpot (weekbedrag, groepsnaam) VALUES (?,?)");	
		
		stmt.setDouble(1, gp.getWeekbedrag());	
		stmt.setString(2, gp.getGroepsnaam());
		
		stmt.executeUpdate();
		stmt.close();
		con.close();
		return gp;
	}
	
	public List<Geldpot> vindWeekbedrag(String groep) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM geldpot WHERE groepsnaam = '"+groep+"'");
		ResultSet rs = stmt.executeQuery();
		List<Geldpot> geldPot = new ArrayList<Geldpot>();
		
		while (rs.next()){
			
			int geldpot_id = rs.getInt("geldpot_id");
			double weekbedrag = rs.getDouble("weekbedrag");
			String groepsnaam = rs.getString("groepsnaam");
			
			Geldpot gp = new Geldpot(geldpot_id, weekbedrag, groepsnaam);
			geldPot.add(gp);
		}
		rs.close();
		stmt.close();
		con.close();
		return geldPot;
	}
	
	public List<Geldpot> vindGeldpotten() throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM geldpot");
		ResultSet rs = stmt.executeQuery();
		List<Geldpot> geldPot = new ArrayList<Geldpot>();
		
		while (rs.next()){
			
			int geldpot_id = rs.getInt("geldpot_id");
			double weekbedrag = rs.getDouble("weekbedrag");
			String groepsnaam = rs.getString("groepsnaam");
			
			Geldpot gp = new Geldpot(geldpot_id, weekbedrag, groepsnaam);
			geldPot.add(gp);
		}
		rs.close();
		stmt.close();
		con.close();
		return geldPot;
	}
	
	
	
	public Geldpot updateWeekbedrag(Geldpot gp) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
				"UPDATE geldpot SET weekbedrag = ? WHERE groepsnaam = ?");
		stmt.setDouble(1, gp.getWeekbedrag());
		stmt.setString(2, gp.getGroepsnaam());
		stmt.executeQuery();
		stmt.close();
		con.close();
		return gp;
	}
	
	public Geldpot vindWeekbedragBijGroepsnaam(String gn) throws SQLException {
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT weekbedrag FROM geldpot WHERE groepsnaam = '"+gn+"'");
		ResultSet rs = stmt.executeQuery();
		List<Geldpot> geldpotLijst = new ArrayList<Geldpot>();
		while (rs.next()) {		
			double weekbedrag = rs.getDouble("weekbedrag");
			Geldpot gp = new Geldpot(weekbedrag);
			geldpotLijst.add(gp);
		}
		rs.close();
		stmt.close();
		con.close();
		return geldpotLijst.get(0);		
	}
}
