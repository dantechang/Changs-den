CREATE TABLE AIRPORT( 
    Airport_Code CHAR(3), 
    Name VARCHAR2(30) NOT NULL,  
    City VARCHAR2(30) NOT NULL,  
    State CHAR(2) NOT NULL, 
    PRIMARY KEY(Airport_code) 
); 

CREATE TABLE FLIGHT( 
    Flight_number CHAR(5), 
    Airline VARCHAR2(50) NOT NULL, 
    Weekdays NUMBER(1) NOT NULL, 
    PRIMARY KEY(Flight_number)
); 

CREATE TABLE FLIGHT_LEG( 
    Flight_number CHAR(5), 
    Leg_number NUMBER(1), 
    Departure_airport_code CHAR(3) NOT NULL, 
    Scheduled_departure_time NUMBER(2,2) NOT NULL, 
    Arrival_airport_code CHAR(3) NOT NULL, 
    Scheduled_arrival_time NUMBER(2,2) NOT NULL, 
    PRIMARY KEY(Flight_number, Leg_number), 
    FOREIGN KEY (Flight_number) REFERENCES FLIGHT(Flight_number), 
    FOREIGN KEY(Departure_airport_code) REFERENCES AIRPORT(Airport_Code), 
    FOREIGN KEY (Arrival_airport_code) REFERENCES AIRPORT(Airport_Code)
); 



CREATE TABLE LEG_INSTANCE( 
    Flight_number CHAR(5), 
    Leg_number NUMBER(1), 
    FDate DATE, 
    Num_available_seats NUMBER(3) NOT NULL, 
    Airplane_id VARCHAR2(20) NOT NULL, 
    Departure_airport_code CHAR(3) NOT NULL,
    Departure_time NUMBER(2,2) NOT NULL,  
    Arrival_airport_code CHAR(3) NOT NULL,  
    Arrival_time NUMBER(2,2) NOT NULL, 
    PRIMARY KEY(Flight_number, Leg_number, FDate), 
    FOREIGN KEY (Flight_number, Leg_number) REFERENCES FLIGHT_LEG(Flight_number, Leg_number), 
    FOREIGN KEY(Departure_airport_code) REFERENCES AIRPORT (Airport_Code), 
    FOREIGN KEY(Arrival_airport_code) REFERENCES AIRPORT (Airport_Code)
); 

CREATE TABLE FARE( 
    Flight_number CHAR(5), 
    Fare_code CHAR(2), 
    Amount VARCHAR2(10) NOT NULL, 
    Restrictions VARCHAR2(50), 
    PRIMARY KEY(Flight_number, Fare_code), 
    FOREIGN KEY (Flight_number) REFERENCES FLIGHT(Flight_number)
); 

CREATE TABLE SEAT_RESERVATION( 
    Flight_number CHAR(5), 
    Leg_number NUMBER(1), 
    FDate DATE, 
    Seat_number VARCHAR2(3), 
    Customer_name VARCHAR2(50) NOT NULL, 
    Customer_phone CHAR(12), 
    PRIMARY KEY(Flight_number, Leg_number, FDate, Seat_number), 
    FOREIGN KEY(Flight_number, Leg_number, FDate) REFERENCES LEG_INSTANCE(Flight_number, Leg_number, FDate)
); 
