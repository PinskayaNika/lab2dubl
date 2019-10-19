package com.examples.reduceside;

import javafx.util.Pair;

public class AirportWritable {
    private static final String DELIMITER = ",";
    private Pair<String, String> airportPair;

    public AirportWritable(String airport) {
        int share ;
        String airportID, airportName;

        if (!airport.contains("Description")) {
            share = airport.indexOf(DELIMITER);
            airportID = airport.substring(1, share - 1);
            airportName = airport.substring(share + 2, airport.length() - 1);
            if ((!airportID.isEmpty()) && (!airportName.isEmpty())) {
                airportPair = new Pair<String, String>(airportID, airportName);
            }
        }
    }

    public Pair<String, String> getAirportPair() {
        return airportPair;
    }
}
