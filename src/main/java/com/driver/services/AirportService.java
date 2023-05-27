package com.driver.services;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.repository.AirportRepository;

import java.util.Date;
import java.util.List;

public class AirportService {

    private static AirportRepository airportRepository =new AirportRepository();

    public static void addAirport(Airport airport) {
        airportRepository.addAirport(airport);
    }

    public String getLargestAirportName() {
        List<Airport> allAirport=airportRepository.getAllAirport();
        int min=-1;
        String str="";
        for (Airport airport:allAirport){
            if(min<airport.getNoOfTerminals()){
                min=airport.getNoOfTerminals();
                str=airport.getAirportName();
            }
            else if (min==airport.getNoOfTerminals()) {
                int check=str.compareTo(airport.getAirportName());
                if(check>0){
                    str=airport.getAirportName();
                }
            }
        }
        return str;
    }

    public double getShortestDurationOfPossibleBetweenTwoCities(City fromCity, City toCity) {
        List<Flight> flightList=airportRepository.getAllFlight();
        double min=Double.MAX_VALUE;
        for(Flight flight:flightList){
            if(flight.getFromCity().equals(fromCity) && flight.getToCity().equals(toCity) && min>flight.getDuration()){
                min=flight.getDuration();
            }
        }
        if(min==Double.MAX_VALUE)return -1;
        return min;
    }
    public String bookTicket(Integer flightId, Integer passengerId) {
        return airportRepository.bookTicket(flightId,passengerId);
    }

    public String cancelATicket(Integer flightId, Integer passengerId) {
        return airportRepository.cancelATicket(flightId,passengerId);
    }
}
