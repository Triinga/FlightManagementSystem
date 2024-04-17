# Flight Management System
This is a Flight Management System implemented using Spring Boot. It allows users to perform various operations related to flights, such as adding new flights, updating flight information, deleting flights, and searching for flights based on different criteria.

## Overview
Add New Flight: Users can add a new flight to the system.
Update Flight: Users can update existing flight information, either by updating all fields or by updating specific fields individually.
Delete Flight: Users can delete a flight from the system.
Search Flights: Users can search for flights based on arrival time, departure time, or both.

## Tech Stack
Java
Spring Boot
Spring Data JPA
H2 Database

## API Endpoints
GET /flightlist: Get a list of all flights.
POST /newflight: Add a new flight.
GET /findbyarrivaldate: Find flights by arrival date.
GET /findbydeparturedate: Find flights by departure date.
GET /findbydepartureandarrivaltime: Find flights by departure and arrival times.
PUT /updateflight/{id}: Update an existing flight.
GET /deleteflight/{id}: Delete a flight.
PUT /update1field/{id}: Update a specific field of a flight.
