package com.fiek.tringa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AppController {
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/flightlist")
    public Iterable<Flight> getAllEvents() {
        return flightRepository.findAll();
    }

    @PostMapping("/newflight")
    public Flight addEvent(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    @GetMapping("/findbyarrivaldate")
    public Iterable<Flight> findArrivalDateFlights(@RequestParam String arrivalTime) {
        return flightRepository.findFlightByArrivalTime(arrivalTime);
    }

    @GetMapping("/findbydeparturedate")
    public Iterable<Flight> findDepartureDateFlights(@RequestParam String departureTime) {
        return flightRepository.findFlightByDepartureTime(departureTime);
    }

    @GetMapping("/findbydepartureandarrivaltime")
    public Iterable<Flight> findDepartureAndArrivalDateFlights(@RequestParam String departureTime,
                                                               @RequestParam String arrivalTime) {
        return flightRepository.findFlightByDepartureTimeAndArrivalTime(departureTime, arrivalTime);
    }

        @PutMapping("/updateflight/{id}")
        public Flight updateFlight(@PathVariable Integer id, @RequestBody Flight flight) {
            Optional<Flight> flightOptional =
                    flightRepository.findById(id);
            if (flightOptional.isPresent()) {
                flight.setFlightId(id);
                return flightRepository.save(flight);
            } else return null;
        }

    @GetMapping("/deleteflight/{id}")
    public String deleteFlight(@PathVariable Integer id) {
        flightRepository.deleteById(id);
        return "flight deleted";
    }


    //to update only 1 field
    @PutMapping("/update1field/{id}")
    public Flight updateFlightv2(@PathVariable Integer id, @RequestParam String fieldName, @RequestParam String updatedValue) {
        Optional<Flight> flightOptional = flightRepository.findById(id);

        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.orElse(null);
            switch (fieldName) {
                case "airline":
                    flight.setAirline(updatedValue);
                    break;
                case "departureAirport":
                    flight.setDepartureAirport(updatedValue);
                    break;

                case "destinationAirport":
                    flight.setDestinationAirport(updatedValue);
                    break;

                case "departureTime":
                    flight.setDepartureTime(updatedValue);
                    break;

                case "arrivalTime":
                    flight.setArrivalTime(updatedValue);
                    break;

                default:
                    // Handle unsupported field name or provide an error response
                    return null;
            }
            return flightRepository.save(flight);

        } else
            return null;
    }
}
