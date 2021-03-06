package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {
	private double longitude;
	private double latitude;
	
	public double getLongitude() {
		return longitude;
	}
	public double getLatitude() {
		return latitude;
	}

}
