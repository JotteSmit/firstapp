package nl.hu.ipass.project.webservices;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Favorietenlijst {
	
	int favorietenlijst_id;
	private String naam;
	private String merk;
	private Date datum;
	private String groepsnaam;
	
	public Favorietenlijst(int favorietenlijst_id, String naam, String merk, Date datum, String groepsnaam){
		this.favorietenlijst_id = favorietenlijst_id;
		this.naam = naam;
		this.merk = merk;
		this.datum = datum;
		this.groepsnaam = groepsnaam;
	}
	
	public Favorietenlijst(String naam, String merk, String groepsnaam) {
		this.naam = naam;
		this.merk = merk;
		this.groepsnaam = groepsnaam;
	}

	public int getFavorietenlijst_id() {
		return favorietenlijst_id;
	}

	public void setFavorietenlijst_id(int favorietenlijst_id) {
		this.favorietenlijst_id = favorietenlijst_id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}

	public String getDatum() {
		Date date = datum;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = dateFormat.format(date);
		return strDate;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getGroepsnaam() {
		return groepsnaam;
	}

	public void setGroepsnaam(String groepsnaam) {
		this.groepsnaam = groepsnaam;
	}	
	
	

}
