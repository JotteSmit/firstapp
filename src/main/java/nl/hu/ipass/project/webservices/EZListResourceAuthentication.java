package nl.hu.ipass.project.webservices;

import java.security.Key;
import java.util.Calendar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.ipass.project.persistence.UserDAO;

@Path("/authentication")
public class EZListResourceAuthentication {
	final static public Key key = MacProvider.generateKey();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser( 
			@FormParam("email") String email, 
			@FormParam("wachtwoord") String wachtwoord, @FormParam("groep") String groepsnaam) {
		try {  
			//Authenticate the user against the database 
			UserDAO dao = new UserDAO(); 
			String rol = dao.findRoleForUsernameAndPassword(email, wachtwoord, groepsnaam);
			
			if (rol == null) { throw new IllegalArgumentException("No user found!"); } 
				
			// Issue a token for the user 
			Calendar expiration = Calendar.getInstance(); 
			expiration.add(Calendar.MINUTE,30); 
			
			String token = Jwts.builder() 	
				.setSubject(email)
				.claim("rol", rol) .setExpiration(expiration.getTime())
			    .signWith(SignatureAlgorithm.HS512, key) .compact();

			// Return the token on the response 
			return Response.ok(token).build();

		} catch (JwtException | IllegalArgumentException e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
}
