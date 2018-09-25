package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class TransportClient {
	private static final String APP_ID = "034b08e6";
	private static final String APP_KEY = "4510ea12c21fb294a20fb777357cc33e";
    private static final String API_URL = "http://transportapi.com";

    private Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

    public List<ArrivalPrediction> getArrivalPredictions(String atcocode) {
         return client.target(API_URL)
                 .path("/v3/uk/bus/stop/" + atcocode + "/live.json")
                 .queryParam("app_id", APP_ID)
                 .queryParam("app_key", APP_KEY)
                 .queryParam("group", "no")
                 .queryParam("limit", 5)
                 .request(MediaType.APPLICATION_JSON_TYPE)
                 .get(NextBusesResult.class)
                 .getArrivalPredictions();
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class NextBusesResult {
    	public Departures departures;
    	
    	private List<ArrivalPrediction> getArrivalPredictions() {
    		return departures.all;
    	}
    }
    
    private static class Departures {
    	public List<ArrivalPrediction> all;
    }
}
