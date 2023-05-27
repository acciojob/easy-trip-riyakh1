package com.driver.services;

import com.driver.model.Airport;
import com.driver.repository.AirportRepository;

public class AirportService {

    private static AirportRepository airportRepository =new AirportRepository();

    public static void addAirport(Airport airport) {
        airportRepository.addAirport(airport);
    }
}
