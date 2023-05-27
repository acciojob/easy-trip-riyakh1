package com.driver.repository;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;

import java.util.*;

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

    public String bookTicket(Integer flightId, Integer passengerId) {
        bookingCount.put(passengerId,bookingCount.getOrDefault(passengerId,0)+1);

        Flight flight=flightMap.get(flightId);
        List<Integer> listOfPassenger=flightPassenger.getOrDefault(flightId,new ArrayList<>());
        if (flight.getMaxCapacity()==listOfPassenger.size())return "FAILURE";

        List<Integer> listOfFilghtsWithPasenger=passengerWithFlightsMap.getOrDefault(passengerId,new ArrayList<>());
        listOfFilghtsWithPasenger.add(flightId);
        passengerWithFlightsMap.put(passengerId,listOfFilghtsWithPasenger);

        listOfPassenger.add(passengerId);
        flightPassenger.put(flightId,listOfPassenger);
        return "SUCCESS";
    }
}
