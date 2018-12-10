# Distributed-Systems-Project
This repository contains a project for the Software Development module Distributed Systems. The Project was to use JAX-RS/Jersey, Java RMI and JAXB frameworks to develop a simple Car Hire Booking system. 

My project is structured around my database having 3 tables.
- Rentals
- Accounts 
- Cars

The application allows the user to read, create, update and delete rentals. An admin user can view all rentals in the system. 

# Set-up
## Software
To run this project it is recommended that you install the following software
- Install [git](https://git-scm.com/)
- Install [WAMP](https://sourceforge.net/projects/wampserver/)
- Install [Eclipse JEE](https://www.eclipse.org/downloads/packages/release/2018-09/r/eclipse-ide-java-ee-developers)
- Install [Tomcat 7](https://tomcat.apache.org/download-70.cgi)
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
## Running
- To run the application you first need open Eclipse JEE. 
- Once Eclipse is open click 'File' and then click 'Open Files from Filesystem...'
- Navigate to where you cloned the repository and open one project at a time by repeating the above step. 
- Once you have added all four projects you should see the four in the explorer to the left of the screen.
- Depending on your java version you may need to change the java build path for each individual project.
- Setup tomcat by clicking [here](https://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.stardust.docs.wst%2Fhtml%2Fwst-integration%2Fconfiguration.html)

You should now be able to run the projects. 
- First run the RmiDatabaseServer by navigating down to the package ie.gmit.sw.ds.rmi within the RmiDatabaseServer and right clicking on ServerSetup and run as 'Java Application'
- Next run the RestfulWebService by right clicking on the project and click 'run as' & 'Run on Server'.

You can now run either the Web Client or the Desktop Client. To run the Web Client 
- Right click on CarBookingWebClient then click on 'run as' and then 'Spring Boot App' if you have spring installed on eclipse otherwise navigate down to the package com.webclient right click on WebappApplication and click 'run as' and click 'Java Application' 
- Open a browser and in the addess bar type 'localhost:9090', the webapp should now be running. 
- By clicking **Create Booking** you will be asked whether it is for a new customer or an existing customer. If you click new customer you will then need to create an account. If you click exisiting customer you can create a booking by filling the input boxes. User Account number **1010** for testing purposes.
- By clicking **Manage Booking** you will be asked to enter the account number you wish to manage. Again use **1010** for testing purposes. If you enter a wrong account number you will be told. If successful you will be shown the rental. You can update the car, rental date or return date under that particular account number.
- By clicking the **View all Bookings** you will be able to view all the rentals that have been created. Before you can view the bookings you will have to put in a username and password. This has been set to username = 'user' and password has been set to 'user'. Once entered you will be able to view all users.
- After viewing all booking if you click the **Logout** button you will have to re-enter your username and password if you wish to view all bookings again. 

To Run the Desktop Client 
- Right navigate to the package ie.gmit.sw.ds.gui and right click 'Runner', click 'run as' and 'Java Application'.
- The options are the same the above Webapplication but instead of clicking links you need to enter the number of the option. 

## Extra Functionality
- I packaged the recourses into Jar files and War files the can be found [here](https://github.com/kevind992/Distributed-Systems-Project/tree/master/JAR-WAR)
- I created a Desktop Client this can be found [here](https://github.com/kevind992/Distributed-Systems-Project/tree/master/DesktopClient)
- I added an admin function for Viewing all Rentals. To access the admin fuction the user needs to enter a username and password.
