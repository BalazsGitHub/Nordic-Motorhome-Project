/*
package teletearbies.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import teletearbies.entity.*;
import teletearbies.service.*;

import javax.annotation.PostConstruct;

//Test push

@Configuration
public class InitialData {

    @Autowired
    private BrandService brandService;

    @Autowired
    private MotorhomeService motorhomeService;

    @Autowired
    private CancellationService cancellationService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SeasonService seasonService;

    @Autowired
    private CustomerService customerService;
    @PostConstruct
    public void initialiseDatabase() {

        Brand brand1 = new Brand("American coach", "Eagle", 4000, 12);
        Brand brand2 = new Brand("Jayco", "Alante", 3500, 10);

        Brand brand3 = new Brand("Fleetwood RV", "Discovery", 3000, 8);

        Brand brand4 = new Brand("Mercedes-benz", "Hymer B-class", 1500, 4);

        brandService.saveBrand(brand1);
        brandService.saveBrand(brand2);
        brandService.saveBrand(brand3);
        brandService.saveBrand(brand4);


        Motorhome motorhome1 = new Motorhome("Ymir", "benzin", 1000, brand1);
        Motorhome motorhome2 = new Motorhome("Heimdal", "diesel", 2000, brand2);
        Motorhome motorhome3 = new Motorhome("Odin", "benzin", 3000, brand3);
        Motorhome motorhome4 = new Motorhome("Thor", "diesel", 4000, brand4);
        Motorhome motorhome5 = new Motorhome("Vidar", "benzin", 5000, brand3);


        motorhomeService.saveMotorhome(motorhome1);
        motorhomeService.saveMotorhome(motorhome2);
        motorhomeService.saveMotorhome(motorhome3);
        motorhomeService.saveMotorhome(motorhome4);
        motorhomeService.saveMotorhome(motorhome5);



        Employee employee1 = new Employee("Barbara Santa", "Sales assistant", "55512131415");
        Employee employee2 = new Employee("Monica Lewinsky", "Sales assistant", "55522232425");
        Employee employee3 = new Employee("Cindy Crawford", "Sales assistant", "55532333435");
        Employee employee4 = new Employee("Mr. Robot", "Sales assistant", "55542434445");
        Employee employee5 = new Employee("Claudia Schiffer", "Cleaning staff", "55552535455");
        Employee employee6 = new Employee("Heidi Klum", "Cleaning staff", "55562636465");
        Employee employee7 = new Employee("Big Gay Al", "Auto mechanic", "55572737475");
        Employee employee8 = new Employee("John Doe", "Bookkeeper", "55582838485");

        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee1);


        Season seasonLow = new Season("Low Season", 1);
        Season seasonMiddle = new Season("Middle Season", 1.3);
        Season seasonPeak = new Season("Peak Season", 1.6);


        seasonService.saveSeason(seasonLow);
        seasonService.saveSeason(seasonMiddle);
        seasonService.saveSeason(seasonPeak);


        Customer customer1 = new Customer("Miss Iwantitall", "+180012131415", "11773345 98765412 74185296 36925814", "Elm street 13. Springwood, USA");
        Customer customer2 = new Customer("Mr. Fake Name", "+18002122232425", "1144559927 852147963 94581478 12349876", "Very long str. 22, Fort Lauderdale, USA");
        Customer customer3 = new Customer("Heinrich Goldberg", "+495556714234", "44668812 41238569 65471235 95175345", "Mariahilfe str. 33, Vienna, Austria");

        customerService.saveCustomer(customer1);
        customerService.saveCustomer(customer2);
        customerService.saveCustomer(customer3);

        Cancellation noCancellation = new Cancellation("50 days", 20.00);
        Cancellation cancellation1 = new Cancellation("49-15 days", 50.00);
        Cancellation cancellation2 = new Cancellation("14-1 days", 80.00);
        Cancellation cancellation3 = new Cancellation("on rental day", 95.00);

        cancellationService.saveCancellation(cancellation1);
        cancellationService.saveCancellation(cancellation2);


        Extra extra1 = new Extra("bike rack", 250);
        Extra extra2 = new Extra("mattress", 200);
        Extra extra3 = new Extra("bicycle", 300);
        Extra extra4 = new Extra("motorhoe", 999);
        Extra extra5 = new Extra("trailer", 500);

    }
}
*/
