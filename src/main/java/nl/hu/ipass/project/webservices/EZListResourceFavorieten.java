package nl.hu.ipass.project.webservices;

import java.io.InputStream;
import java.sql.SQLException;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/favorieten")
public class EZListResourceFavorieten {
	EZListService service = ServiceProvider.getEZListService();
	
	@GET
	@Produces("application/json")
	@Path("/{groep}")
	public String getFavorieten(@PathParam("groep") String groep) throws SQLException {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Favorietenlijst fl : service.getFavorietenByGroep(groep)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("favorietenlijst_id", fl.getFavorietenlijst_id());
			job.add("naam", fl.getNaam());
			job.add("merk", fl.getMerk());
			job.add("datum", fl.getDatum());
			job.add("groepsnaam", fl.getGroepsnaam());
			jab.add(job);
		}		
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@POST
	@Produces("application/json")
	public String createFavoriet(InputStream is) throws SQLException {
		JsonObject object = Json.createReader(is).readObject();
		String naam = object.getString("naam");
		String merk = object.getString("merk");
		String groepsnaam = object.getString("groepsnaam");
		
		Favorietenlijst newFavoriet = new Favorietenlijst(naam, merk, groepsnaam);
		service.addFavoriet(newFavoriet);
		return Response.ok().build().toString();
	}
	
	@DELETE
	@Produces("application/json")
	@RolesAllowed({"admin"})
	@Path("/{favorietenlijst_id}")
	public Response deleteFavoriet(@PathParam("favorietenlijst_id") int fid) throws SQLException {
		Favorietenlijst found = null;
		for (Favorietenlijst fl : service.getAlleFavorieten()) {
			if (fl.favorietenlijst_id == fid) {
				found = fl; break;
			}
		}	
		if (found == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			service.deleteFavoriet(found);
			return Response.ok().build();
		}
	}

}
