package nl.hu.ipass.project.webservices;

public class Student {
	
	private String email;
	private String voornaam;
	private String achternaam;
	private String wachtwoord;
	private String rol;
	private String groepsnaam;
	
	public Student(String email, String voornaam, String achternaam, String wachtwoord, String rol, String groepsnaam){
		this.email = email;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.wachtwoord = wachtwoord;
		this.rol = rol;
		this.groepsnaam = groepsnaam;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getGroepsnaam() {
		return groepsnaam;
	}

	public void setGroepsnaam(String groepsnaam) {
		this.groepsnaam = groepsnaam;
	}
	
	
	

}
