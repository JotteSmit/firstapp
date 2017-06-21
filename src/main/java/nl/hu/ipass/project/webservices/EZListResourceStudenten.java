package nl.hu.ipass.project.webservices;

import java.io.InputStream;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/studenten")
public class EZListResourceStudenten {
	EZListService service = ServiceProvider.getEZListService();
		
	@POST
	@Produces("application/json")
	@Path("/new")
	public String createStudent(InputStream is) throws SQLException {
		JsonObject object = Json.createReader(is).readObject();
		String email = object.getString("email");
		String voornaam = object.getString("voornaam");
		String achternaam = object.getString("achternaam");
		String wachtwoord = object.getString("wachtwoord");	
		String rol = object.getString("rol");
		String groep = object.getString("groepsnaam");
		
		Student newStudent = new Student(email, voornaam, achternaam, wachtwoord, rol, groep);
		service.addStudent(newStudent);
		return Response.ok().build().toString();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{groep}")
	public String getStudenten(@PathParam("groep") String groep) throws SQLException {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Student sl : service.getAlleStudenten(groep)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("email", sl.getEmail());
			job.add("voornaam", sl.getVoornaam());
			job.add("achternaam", sl.getAchternaam());
			job.add("wachtwoord", sl.getWachtwoord());	
			job.add("rol", sl.getRol());
			job.add("groepsnaam", sl.getGroepsnaam());
			jab.add(job);
		}		
		JsonArray array = jab.build();
		return array.toString();
	}

}
