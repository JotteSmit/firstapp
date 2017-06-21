package nl.hu.ipass.project.persistence;

import nl.hu.ipass.project.webservices.Favorietenlijst;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavorietenlijstDAO extends BaseDAO {
	public Favorietenlijst saveFavoriet(Favorietenlijst fl) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO favorietenlijst (naam, merk, groepsnaam) VALUES (?,?,?)");
		
		stmt.setString(1, fl.getNaam());
		stmt.setString(2, fl.getMerk());
		stmt.setString(3, fl.getGroepsnaam());
		
		stmt.executeUpdate();
		stmt.close();
		con.close();
		return fl;
	}
	
	public List<Favorietenlijst> vindFavorietenByGroep(String groep) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM favorietenlijst WHERE groepsnaam = '"+groep+"'");
		ResultSet rs = stmt.executeQuery();
		List<Favorietenlijst> favorietenLijst= new ArrayList<Favorietenlijst>();
		while(rs.next()){
			
			int favorietenlijst_id = rs.getInt("favorietenlijst_id");
			String naam = rs.getString("naam");
			String merk = rs.getString("merk");
			Date datum = rs.getDate("datum");
			String groepsnaam = rs.getString("groepsnaam");
			
			Favorietenlijst fl = new Favorietenlijst(favorietenlijst_id, naam, merk, datum, groepsnaam);
			favorietenLijst.add(fl);
		}
		rs.close();
		stmt.close();
		con.close();
		return favorietenLijst;
	}

	public List<Favorietenlijst> vindAlleFavorieten() throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM favorietenlijst");
		ResultSet rs = stmt.executeQuery();
		List<Favorietenlijst> favorietenLijst= new ArrayList<Favorietenlijst>();
		while(rs.next()){
			
			int favorietenlijst_id = rs.getInt("favorietenlijst_id");
			String naam = rs.getString("naam");
			String merk = rs.getString("merk");
			Date datum = rs.getDate("datum");
			String groepsnaam = rs.getString("groepsnaam");
			
			Favorietenlijst fl = new Favorietenlijst(favorietenlijst_id, naam, merk, datum, groepsnaam);
			favorietenLijst.add(fl);
		}
		rs.close();
		stmt.close();
		con.close();
		return favorietenLijst;
	}
	
	public boolean deleteFavoriet(Favorietenlijst fl) throws SQLException{
		Connection con = super.getConnection();
		PreparedStatement stmt = con.prepareStatement("DELETE FROM favorietenlijst WHERE favorietenlijst_id = ?");
		stmt.setInt(1, fl.getFavorietenlijst_id());		
		boolean result = stmt.execute();
		stmt.close();
		con.close();
		return result;
	}
	

}
