package nl.hu.ipass.project.webservices;

import java.io.InputStream;
import java.sql.SQLException;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/geldpot")
public class EZListResourceGeldpot {
	EZListService service = ServiceProvider.getEZListService();

	@GET
	@Produces("application/json")
	@Path("/{groep}")
	public String getWeekbedrag(@PathParam("groep") String groep) throws SQLException {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Geldpot gp : service.getWeekbedrag(groep)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("geldpot_id", gp.getGeldpot_id());
			job.add("weekbedrag", gp.getWeekbedrag());
			job.add("groepsnaam", gp.getGroepsnaam());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@POST
	@RolesAllowed({"admin"})
	@Produces("application/json")
	public String createWeekbedrag(InputStream is) throws SQLException {
		JsonObject object = Json.createReader(is).readObject();
		double wb = Double.parseDouble(object.getString("weekbedrag"));
		String gn = object.getString("groepsnaam");
		
		Geldpot newWeekbedrag = new Geldpot(wb, gn);
		service.addGeldpot(newWeekbedrag);
		return Response.ok().build().toString();
	}

	@PUT
	@Produces("application/json")
	@Path("/update/{gn}")
	public Response updateWeekbedrag(@PathParam("gn") String gn, InputStream is) throws SQLException {
		JsonObject object = Json.createReader(is).readObject();
		
		double wb = Double.parseDouble(object.getString("weekbedrag"));
		String groep = object.getString("groepsnaam");
	
		Geldpot weekbedrag = service.getWeekbedragByGroup(gn);
		
		System.out.print(gn);
		
		weekbedrag.weekbedrag = wb;
		weekbedrag.groepsnaam = groep;
		
		if (service.updateGeldpot(weekbedrag) != null) {
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}	
}
