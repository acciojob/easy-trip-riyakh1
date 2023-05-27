package com.driver.repository;

import com.driver.model.Airport;
import com.driver.model.Flight;
import com.driver.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportRepository {

    Map<String , Airport> airportMap=new HashMap<>();
    List<Airport> airportList=new ArrayList<>();
    Map<Integer , Flight>flightMap=new HashMap<>();
    List<Flight> flightList=new ArrayList<>();
    Map<Integer , Passenger>passengerMap=new HashMap<>();

    Map<Integer,List<Integer>> flightPassenger=new HashMap<>();
    Map<Integer,List<Integer>> passengerWithFlightsMap =new HashMap();
    Map<Integer,Integer> bookingCount =new HashMap();
    public void addAirport(Airport airport) {
        String name=airport.getAirportName();
        airportList.add(airport);
        airportMap.put(name,airport);
    }

    public List<Airport> getAllAirport() {
        return airportList;
    }

    public List<Flight> getAllFlight() {
        return flightList;
    }
}
