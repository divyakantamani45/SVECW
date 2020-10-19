package com.rest.RestAPI;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dto.Participants;
import com.ts.dao.ParticipantDAO;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@Path("hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() throws UnsupportedEncodingException {
		System.out.println("Hi...");
		return "Hi Service!";
	}
	
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("getParticipants")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Participants> getParticipants() {

		ParticipantDAO participantDao = new ParticipantDAO();
		List <Participants> ParticipantsList = participantDao.getAllParticipants();

		return ParticipantsList;
	}
    
    @Path("regParticipant")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int regParticipant(Participants participant) {
		System.out.println("Data Recieved in Participant Register : " + participant);
		ParticipantDAO participantDao = new ParticipantDAO();
		return participantDao.register(participant);
	}
    
    @Path("getPatByUserPass/{email}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Participants getPatByUserPass(@PathParam("email") String email,@PathParam("password") String password) {
		System.out.println("Recieved path params: "+email+" "+password); 
		ParticipantDAO participantDao = new ParticipantDAO();
		Participants participants = participantDao.getPatByUserPass(email, password);
		return participants;
	}
    
    
}
