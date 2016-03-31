package com.twair;

import java.util.ArrayList;
import java.util.List;

public class FlightSearch {

    private List<Flight> flightList;

    public FlightSearch(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public FlightSearch byLocation(String source, String destination) {

        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                 matchingFlights.add(flight);
            }
        }
        return new FlightSearch(matchingFlights);
    }
    public FlightSearch byLocation(String source, String destination, int seats) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                int numSeats = seats > 1 ? seats : 1;
                if(numSeats  < flight.getPlane().getNumberOfSeats()) matchingFlights.add(flight);
            }
        }
        return new FlightSearch(matchingFlights);
    }
}
