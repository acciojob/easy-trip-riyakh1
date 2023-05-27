package com.driver.services;

import com.driver.model.Airport;
import com.driver.repository.AirportRepository;

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
}
