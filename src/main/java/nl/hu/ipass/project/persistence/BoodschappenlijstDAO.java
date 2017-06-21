package nl.hu.ipass.project.persistence;

import nl.hu.ipass.project.webservices.Boodschappenlijst;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoodschappenlijstDAO extends BaseDAO {
	public Boodschappenlijst saveBoodschap(Boodschappenlijst bl) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO boodschappenlijst (naam, merk, kosten, groepsnaam) VALUES (?,?,?,?)");
		
		stmt.setString(1, bl.getNaam());
		stmt.setString(2, bl.getMerk());
		stmt.setDouble(3, bl.getKosten());
		stmt.setString(4, bl.getGroepsnaam());
		
		stmt.executeUpdate();
		con.close();
		return bl;		
	}
	
	public List<Boodschappenlijst> vindBoodschappenByGroep(String groep) throws SQLException {
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM boodschappenlijst WHERE groepsnaam = '"+groep+"'");
		ResultSet rs = stmt.executeQuery();
		List<Boodschappenlijst> boodschappenLijst = new ArrayList<Boodschappenlijst>();
		while (rs.next()) {
			
			int bid = rs.getInt("boodschappenlijst_id");
			String naam = rs.getString("naam");
			String merk = rs.getString("merk");
			Date datum = rs.getDate("datum");
			double kosten = rs.getDouble("kosten");
			String groepsnaam = rs.getString("groepsnaam");
			
			Boodschappenlijst bl = new Boodschappenlijst(bid, naam, merk, datum, kosten, groepsnaam);
			boodschappenLijst.add(bl);
		}
		rs.close();
		con.close();
		return boodschappenLijst;
	}

	public List<Boodschappenlijst> vindAlleBoodschappen() throws SQLException {
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM boodschappenlijst");
		ResultSet rs = stmt.executeQuery();
		List<Boodschappenlijst> boodschappenLijst = new ArrayList<Boodschappenlijst>();
		while (rs.next()) {
			
			int bid = rs.getInt("boodschappenlijst_id");
			String naam = rs.getString("naam");
			String merk = rs.getString("merk");
			Date datum = rs.getDate("datum");
			double kosten = rs.getDouble("kosten");
			String groepsnaam = rs.getString("groepsnaam");
			
			Boodschappenlijst bl = new Boodschappenlijst(bid, naam, merk, datum, kosten, groepsnaam);
			boodschappenLijst.add(bl);
		}
		rs.close();
		con.close();
		return boodschappenLijst;
	}
	
	public boolean deleteBoodschap(Boodschappenlijst bl) throws SQLException {
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("DELETE FROM boodschappenlijst WHERE boodschappenlijst_id = ?");
		stmt.setInt(1, bl.getBoodschappenlijst_id());
		boolean result = stmt.execute();
		con.close();
		return result;
	}

}
