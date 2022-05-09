package teletearbies.common;

import org.springframework.context.annotation.Configuration;
import teletearbies.entity.*;

import javax.annotation.PostConstruct;

//@Configuration
public class InitialData {

    //@PostConstruct
    public void initialiseDatabase() {

        Brand brand1 = new Brand("American coach", "Eagle", 4000, 12);
        Brand brand2 = new Brand("American coach", "Dream", 4000, 12);
        Brand brand3 = new Brand("Jayco", "Alante", 3500, 10);
        Brand brand4 = new Brand("Jayco", "Embark", 3500, 10);
        Brand brand5 = new Brand("Fleetwood RV", "Discovery", 3000, 8);
        Brand brand6 = new Brand("Fleetwood RV", "Southwind", 2500, 6);
        Brand brand7 = new Brand("Mercedes-benz", "Hymer B-class", 1500, 4);
        Brand brand8 = new Brand("Mercedes-benz", "Hymer Exsis", 1500, 3);


        Motorhome motorhome1 = new Motorhome("Ymir", "benzin", 1000, brand1);
        Motorhome motorhome2 = new Motorhome("Heimdal", "diesel", 2000, brand1);
        Motorhome motorhome3 = new Motorhome("Odin", "benzin", 3000, brand2);
        Motorhome motorhome4 = new Motorhome("Thor", "diesel", 4000, brand2);
        Motorhome motorhome5 = new Motorhome("Vidar", "benzin", 5000, brand3);
        Motorhome motorhome6 = new Motorhome("Freja", "diesel", 6000, brand4);
        Motorhome motorhome7 = new Motorhome("Tyr", "benzin", 7000, brand5);
        Motorhome motorhome8 = new Motorhome("Loki", "diesel", 8000, brand6);
        Motorhome motorhome9 = new Motorhome("Hela", "benzin", 9000, brand7);
        Motorhome motorhome10 = new Motorhome("Idun", "diesel", 10000, brand8);

        Season seasonLow = new Season("Low Season", 1);
        Season seasonMiddle = new Season("Middle Season", 1.3);
        Season seasonPeak = new Season("Peak Season", 1.6);

        Employee employee1 = new Employee("Barbara Santa", "Sales assistant", "55512131415");
        Employee employee2 = new Employee("Monica Lewinsky", "Sales assistant", "55522232425");
        Employee employee3 = new Employee("Cindy Crawford", "Sales assistant", "55532333435");
        Employee employee4 = new Employee("Mr. Robot", "Sales assistant", "55542434445");
        Employee employee5 = new Employee("Claudia Schiffer", "Cleaning staff", "55552535455");
        Employee employee6 = new Employee("Heidi Klum", "Cleaning staff", "55562636465");
        Employee employee7 = new Employee("Big Gay Al", "Auto mechanic", "55572737475");
        Employee employee8 = new Employee("John Doe", "Bookkeeper", "55582838485");

        Customer customer1 = new Customer("Miss Iwantitall", "+180012131415", "11773345 98765412 74185296 36925814", "Elm street 13. Springwood, USA");
        Customer customer2 = new Customer("Mr. Fake Name", "+18002122232425", "1144559927 852147963 94581478 12349876", "Very long str. 22, Fort Lauderdale, USA");
        Customer customer3 = new Customer("Heinrich Goldberg", "+495556714234", "44668812 41238569 65471235 95175345", "Mariahilfe str. 33, Vienna, Austria");

        Cancellation noCancellation = new Cancellation("50 days", 20.00);
        Cancellation cancellation1 = new Cancellation("49-15 days", 50.00);
        Cancellation cancellation2 = new Cancellation("14-1 days", 80.00);
        Cancellation cancellation3 = new Cancellation("on rental day", 95.00);

        Extra extra1 = new Extra("bike rack", 250);
        Extra extra2 = new Extra("mattress", 200);
        Extra extra3 = new Extra("bicycle", 300);
        Extra extra4 = new Extra("motorhoe", 999);
        Extra extra5 = new Extra("trailer", 500);


    }
}
