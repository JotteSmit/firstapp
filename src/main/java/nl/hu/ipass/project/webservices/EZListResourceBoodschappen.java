package nl.hu.ipass.project.webservices;

import java.io.InputStream;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/boodschappen")
public class EZListResourceBoodschappen {
	EZListService service = ServiceProvider.getEZListService();
	
	@GET
	@Produces("application/json")
	@Path("/{groep}")
	public String getBoodschappen(@PathParam("groep") String groep) throws SQLException {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Boodschappenlijst bl : service.getBoodschappenByGroep(groep)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("boodschappenlijst_id", bl.getBoodschappenlijst_id());
			job.add("naam", bl.getNaam());
			job.add("merk", bl.getMerk());
			job.add("datum", bl.getDatum());
			job.add("kosten", bl.getKosten());
			job.add("groepsnaam", bl.getGroepsnaam());
			jab.add(job);
		}		
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@POST
	@Produces("application/json")
	public String createBoodschap(InputStream is) throws SQLException {
		JsonObject object = Json.createReader(is).readObject();
		String naam = object.getString("naam");
		String merk = object.getString("merk");
		double kosten = Double.parseDouble(object.getString("kosten"));
		String groepsnaam = object.getString("groepsnaam");
			
		Boodschappenlijst newBoodschap = new Boodschappenlijst(naam, merk, kosten, groepsnaam);
		service.addBoodschap(newBoodschap);
		return Response.ok().build().toString();
	}
	
	@DELETE
	@Produces("application/json")
	@Path("/{boodschappenlijst_id}")
	public Response deleteBoodschap(@PathParam("boodschappenlijst_id") int bid) throws SQLException {
		Boodschappenlijst found = null;
		for (Boodschappenlijst bl : service.getAlleBoodschappen()) {
			if (bl.boodschappenlijst_id == bid) {
				found = bl; break;
			}
		}	
		if (found == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			service.deleteBoodschap(found);
			return Response.ok().build();
		}
	}
	
	}

