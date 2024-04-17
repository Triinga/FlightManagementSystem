package com.fiek.tringa.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends CrudRepository<Flight,Integer> {
    Iterable<Flight> findFlightByArrivalTime(@Param("arrivalTime") String arrivalTime);
    Iterable<Flight> findFlightByDepartureTime(@Param("departureTime") String departureTime);
    Iterable<Flight> findFlightByDepartureTimeAndArrivalTime(@Param("departureTime") String departureTime,
                                                             @Param("arrivalTime") String arrivalTime);
}
