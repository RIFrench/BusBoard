package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NearbyBusStops {
	private String atcocode;
	
	  private NearbyBusStops() {}
	  
	  public String getAtcoCode () {
		  return atcocode;
	  }

}
