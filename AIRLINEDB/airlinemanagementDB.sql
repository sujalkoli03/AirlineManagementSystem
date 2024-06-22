create database airlinemanagementsystem;
use airlinemanagementsystem;
create table login(username varchar(20), password varchar(20));
insert into login values('admin', 'admin');

create table passenger(name varchar(20), nationality varchar(20), phone varchar(15), address varchar(50), aadhar varchar(20), gender varchar(20));

create table flight(flight_code varchar(20), flight_name varchar(20), source varchar(40), destination varchar(40));
insert into flight values("101", "IA-1812", "Chinchwad", "Mumbai");
insert into flight values("102", "IA-2002", "Chinchwad", "Andaman");
insert into flight values("103", "IA-1901", "Pimpri", "Goa");
insert into flight values("104", "IA-2511", "Pimpri", "Kashmir");
insert into flight values("105", "IA-3110", "Pimpri", "Ayodhya");
insert into flight values("106", "IA-1907", "Chinchwad", "Lakshadweep");

select * from passenger;

create table reservation(PNR varchar(15), TICKET varchar(20), aadhar varchar(20), name varchar(20), nationality varchar(30), flightname varchar(15), flightcode varchar(20), src varchar(30), des varchar(30), ddate varchar(30));
select * from reservation;

create table cancel(pnr varchar(20), name varchar(40), cancelno varchar(20), fcode varchar(20), ddate varchar(30));
