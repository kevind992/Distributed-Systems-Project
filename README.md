# Distributed-Systems-Project
This repository contains a project for the Software Development module Distributed Systems. The Project was to use JAX-RS/Jersey, Java RMI and JAXB frameworks to develop a simple Car Hire Booking system.

# Set-up
## Software
To run this project it is recommended that you install the following software
- Install [git](https://git-scm.com/)
- Install [WAMP](https://sourceforge.net/projects/wampserver/)
- Install [Eclipse JEE](https://www.eclipse.org/downloads/packages/release/2018-09/r/eclipse-ide-java-ee-developers)
## Git
After you have completed installing the above software you can now clone down the repository. To do so open a terminal and navigate to where you wish to clone the repository and type the following
```sh
   $ git clone https://github.com/kevind992/Distributed-Systems-Project.git
``` 
## Create DATABASE
To set up the database open wamp mySQL terminal. Once open copy the following sql commands into the terminal to create the database
```sh
    DROP DATABASE car_rental_booking_db;
    CREATE DATABASE car_rental_booking_db;
    USE car_rental_booking_db;

    drop table if exists Cars;
    create table Cars (
       rental_id int,
       car_reg varchar(20),
       car_make varchar(50),
       car_model varchar(50),
       fuel_type varchar(50),
       seats int,
       tranmission varchar(20),
       car_size varchar(20),
       car_rented tinyint(1),
       primary key (rental_id)
    );

    drop table if exists Accounts;
    create table Accounts (
        acc_no int,
        first_name varchar(50),
        surname varchar(50),
        dob Date,
        address varchar(50),
        primary key(acc_no)
    );

    drop table if exists Rentals;
    create table Rentals (
        id int NOT NULL AUTO_INCREMENT,
        rental_id int,
        acc_no int,
        rental_date Date,
        return_date Date,
        primary key(id),
        foreign key(acc_no) references Accounts(acc_no),
        foreign key(rental_id) references Cars(rental_id)
    );
``` 
We now need to populate the three tables with some test data, to do so copy the following commands
```sh
    insert into cars values(101, '181-D-4324', 'Ford', 'Focus','Petrol',5,'Manual','Medium',0);
    insert into cars values(102, '172-D-9876', 'BMW', '3-series','Diesal',5,'Manual','Medium',0);
    insert into cars values(103, '182-D-3212', 'Ford', 'Galaxy','Diesal',5,'Automatic','Large',0);
    insert into cars values(104, '181-D-4224', 'Volkswagen', 'Golf','Diesal',5,'Manual','Medium',0);
    insert into cars values(105, '171-D-4224', 'Audi', 'A3','Petrol',3,'Manual','Small',0);
    insert into accounts values(1001, 'Jimmy', 'Smith', '1992-03-26', 'Co. Galway');
    insert into accounts values(1010, 'Peter', 'Burke', '1995-10-19', 'Claregalway, Co. Galway');
    insert into accounts values(1020, 'Meghan', 'Smith', '1991-01-01', 'Oranmore, Co. Galway');
    insert into rentals values(45, 105, 1001, '2018-12-04','2018-12-30');
```
