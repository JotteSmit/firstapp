package nl.hu.ipass.project.webservices;

import java.io.InputStream;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/groepsnaam")
public class EZListResourceGroepsnamen {
	EZListService service = ServiceProvider.getEZListService();
	
	@POST
	@Produces("application/json")
	public String createGroep(InputStream is) throws SQLException {
		JsonObject object = Json.createReader(is).readObject();
		String gn = object.getString("groepsnaam");
	
		Groepsnaam newGroep = new Groepsnaam(gn);
		service.addGroepsnaam(newGroep);
		return Response.ok().build().toString();
	}

}
