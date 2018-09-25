package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class TwoTransportTwoClient {
	private static final String APP_ID = "034b08e6";
	private static final String APP_KEY = "4510ea12c21fb294a20fb777357cc33e";
    private static final String API_URL = "http://transportapi.com";
    
    private Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

    public List<BusStop> getBusStops(String latitude, String longitude) {
         return client.target(API_URL)
                 .path("/v3/uk/places.json")
                 .queryParam("app_id", APP_ID)
                 .queryParam("app_key", APP_KEY)
                 .queryParam("group", "no")
                 .queryParam("limit", 2)
                 .queryParam("type", "bus_stop")
                 .queryParam("lat", latitude)
                 .queryParam("lon", longitude)
                 .request(MediaType.APPLICATION_JSON_TYPE)
                 .get(BusStopsResponse.class)
                 .member;
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class BusStopsResponse {
    	public List<BusStop> member;
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BusStop {
    	public String atcocode;
    }
}
