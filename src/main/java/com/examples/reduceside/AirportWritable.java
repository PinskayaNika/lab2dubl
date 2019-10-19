package com.examples.reduceside;

import javafx.util.Pair;

public class AirportWritable {
    private static final String DELIMITER = ",";
    private static final String SKIPPED_STRING = "Description";

    private Pair<String, String> airportPair;

    public AirportWritable(String airport) {
        int sharing ;
        String airportID, airportName;

        if (!airport.contains(SKIPPED_STRING)) {
            sharing = airport.indexOf(DELIMITER);
            airportID = airport.substring(1, sharing - 1);
            airportName = airport.substring(sharing + 2, airport.length() - 1);
            if ((!airportID.isEmpty()) && (!airportName.isEmpty())) {
                airportPair = new Pair<String, String>(airportID, airportName);
            }
        }
    }

    public Pair<String, String> getAirportPair() {
        return airportPair;
    }
}
