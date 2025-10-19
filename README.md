# Stadium-Seat-Reservation-System

A Java console app for multi-city, multi-stadium seat bookings.
It models venues and seating with OOP (inheritance) and a custom linked list, lets users filter stadiums by city, and shows detailed seat/section status. 
The booking & cancellation flows enforce capacity checks to prevent overbooking, with an optional random pre-fill to simulate live demand.
All bookings persist to CSV and are rehydrated on startup to keep in-memory state in sync across runs. 
Includes an interactive CLI for browsing venues, checking availability, and managing reservations.
