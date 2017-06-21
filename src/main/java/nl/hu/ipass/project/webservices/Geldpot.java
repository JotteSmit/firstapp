package nl.hu.ipass.project.webservices;

public class Geldpot {
	
	int geldpot_id;
	double weekbedrag;
	String groepsnaam;
	
	public Geldpot(int geldpot_id, double weekbedrag, String groepsnaam){
		this.geldpot_id = geldpot_id;
		this.weekbedrag = weekbedrag;
		this.groepsnaam = groepsnaam;
	}
	
	public Geldpot(int geldpot_id, double weekbedrag){
		this.geldpot_id = geldpot_id;
		this.weekbedrag = weekbedrag;
	}

	public Geldpot(double weekbedrag, String groepsnaam) {
		this.weekbedrag = weekbedrag;
		this.groepsnaam = groepsnaam;
	}
	
	public Geldpot(double weekbedrag) {
		this.weekbedrag = weekbedrag;
	}

	public int getGeldpot_id() {
		return geldpot_id;
	}

	public void setGeldpot_id(int geldpot_id) {
		this.geldpot_id = geldpot_id;
	}

	public double getWeekbedrag() {
		return weekbedrag;
	}

	public void setWeekbedrag(double weekbedrag) {
		this.weekbedrag = weekbedrag;
	}

	public String getGroepsnaam() {
		return groepsnaam;
	}

	public void setGroepsnaam(String groepsnaam) {
		this.groepsnaam = groepsnaam;
	}	
	
	

}
