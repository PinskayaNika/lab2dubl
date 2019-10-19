package com.examples.reduceside;

import javafx.util.Pair;

public class FlightWritable {
    private final static int AIRPORT_DESTINATION_ID = 14;
    private final static int FLIGHT_DELAY = 17;
    private final static int TOTAL = 18;
    private static final String DELIMITER = ",";
    private static final String SKIPPED_STRING = "YEAR";

    private Pair<String, String> flightPair;

    public FlightWritable(String flight) {
        String id, delay;
        System.out.println(flight);

        if ((!flight.contains(SKIPPED_STRING)) && (flight.length() > 1)) {
            String[] table = flight.split(DELIMITER);
            if (table.length < TOTAL) {
                return;
            }
            id = table[AIRPORT_DESTINATION_ID];
            delay = table[FLIGHT_DELAY];
            if ((!id.isEmpty()) && (!delay.isEmpty())) {
                this.flightPair = new Pair<String, String>(id, delay);
            }
        }
    }

    public Pair<String, String> getFlightPair() {
        return flightPair;
    }

}
