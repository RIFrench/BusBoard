package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class PostcodeClient {

	private static final String API_URL = "http://api.postcodes.io";
	private Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
	
	public Coordinates getCoordinates(String postcode) {
        return client.target(API_URL)
                .path("/postcodes/" + postcode)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(CoordinatesResult.class)
                .getCoordinates();
   }
	
   @JsonIgnoreProperties(ignoreUnknown = true)
    private static class CoordinatesResult {
    	public Coordinates result;
    	
    	private Coordinates getCoordinates() {
    		return result;
    	}
    }
}
