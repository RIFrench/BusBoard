package training.busboard;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import training.busboard.TwoTransportTwoClient.BusStop;

public class Main {
//    public static void main(String args[]) {
//        String id = promptForStopId();
//
//        List<ArrivalPrediction> arrivalPredictions = new TransportClient().getArrivalPredictions(id);
//
//        arrivalPredictions.stream().sorted(Comparator.comparing(ArrivalPrediction::getBestDepartureEstimate)).limit(5).forEach(prediction ->
//                System.out.println(formatPrediction(prediction))
//        );
//    }
//
//    private static String promptForStopId() {
//        System.out.print("Enter your stop ID: ");
//        // Example: 0180BAC30592
//        return new Scanner(System.in).nextLine();
//    }
//
//    private static String formatPrediction(ArrivalPrediction prediction) {
//        return String.format("%s to %s will leave at: %s",
//                prediction.getLineName(),
//                prediction.getDirection(),
//                prediction.getBestDepartureEstimate());
//    }
	
    public static void main(String args[]) {
        String postcode = promptForPostcode();

        Coordinates coordinates = new PostcodeClient().getCoordinates(postcode);
        System.out.println(formatCoordinates(coordinates));
        
        String latitude = "" + coordinates.getLatitude();
        String longitude = "" + coordinates.getLongitude();
        
        List<BusStop> nearbyBusStops = new TwoTransportTwoClient().getBusStops(latitude, longitude);
        nearbyBusStops.stream().forEach(busStop ->
                   System.out.println(busStop.atcocode));
    }

    private static String promptForPostcode() {
        System.out.print("Enter your postcode: ");
        // Example: 0180BAC30592
        return new Scanner(System.in).nextLine();
    }

    private static String formatCoordinates(Coordinates coordinates) {
        return String.format("Latitude: %f\nLongitude: %f",
                coordinates.getLatitude(),
                coordinates.getLongitude());
    }
}	
