package nl.hu.ipass.project.webservices;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Boodschappenlijst {
	
	int boodschappenlijst_id;
	private String naam;
	private String merk;
	private Date datum;
	private double kosten;
	private String groepsnaam;
	
	public Boodschappenlijst(int boodschappenlijst_id, String naam, String merk, Date datum, double kosten, String groepsnaam){
		this.boodschappenlijst_id = boodschappenlijst_id;
		this.naam = naam;
		this.merk = merk;
		this.datum = datum;
		this.kosten = kosten;
		this.groepsnaam = groepsnaam;
	}
		

	public Boodschappenlijst(String naam, String merk, double kosten, String groepsnaam) {
		this.naam = naam;
		this.merk = merk;
		this.kosten = kosten;
		this.groepsnaam = groepsnaam;
	}


	public int getBoodschappenlijst_id() {
		return boodschappenlijst_id;
	}


	public void setBoodschappenlijst_id(int boodschappenlijst_id) {
		this.boodschappenlijst_id = boodschappenlijst_id;
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


	public double getKosten() {
		return kosten;
	}

	public void setKosten(double kosten) {
		this.kosten = kosten;
	}


	public String getGroepsnaam() {
		return groepsnaam;
	}


	public void setGroepsnaam(String groepsnaam) {
		this.groepsnaam = groepsnaam;
	}
	
	
	

}
