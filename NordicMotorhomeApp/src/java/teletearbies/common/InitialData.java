package teletearbies.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import teletearbies.entity.*;
import teletearbies.service.*;

import javax.annotation.PostConstruct;

@Configuration
public class InitialData {

    @Autowired
    private BrandService brandService;

    @Autowired
    private MotorhomeService motorhomeService;

    @Autowired
    private CancellationService cancellationService;

    @Autowired
    private UserService userService;

    @Autowired
    private SeasonService seasonService;

    @Autowired
    private BookingService bookingService;

    @PostConstruct
    public void initialiseDatabase() {

        Brand brand1 = new Brand("American coach", "Eagle", 4000, 12);
        Brand brand2 = new Brand("American coach", "Dream", 4000, 12);
        Brand brand3 = new Brand("Jayco", "Alante", 3500, 10);
        Brand brand4 = new Brand("Jayco", "Embark", 3500, 10);
        Brand brand5 = new Brand("Fleetwood RV", "Discovery", 3000, 8);
        Brand brand6 = new Brand("Fleetwood RV", "Southwind", 2500, 6);
        Brand brand7 = new Brand("Mercedes-benz", "Hymer B-class", 1500, 4);
        Brand brand8 = new Brand("Mercedes-benz", "Hymer Exsis", 1500, 3);

        brandService.saveBrand(brand1);
        brandService.saveBrand(brand2);
        brandService.saveBrand(brand3);
        brandService.saveBrand(brand4);
        brandService.saveBrand(brand5);
        brandService.saveBrand(brand6);
        brandService.saveBrand(brand7);
        brandService.saveBrand(brand8);

        Motorhome motorhome1 = new Motorhome("Ymir", "benzin", 1000, brand1);
        Motorhome motorhome2 = new Motorhome("Heimdal", "diesel", 2000, brand2);
        Motorhome motorhome3 = new Motorhome("Odin", "benzin", 3000, brand3);
        Motorhome motorhome4 = new Motorhome("Thor", "diesel", 4000, brand4);
        Motorhome motorhome5 = new Motorhome("Vidar", "benzin", 5000, brand3);
        Motorhome motorhome6 = new Motorhome("Freja", "diesel", 6000, brand4);
        Motorhome motorhome7 = new Motorhome("Tyr", "benzin", 7000, brand5);
        Motorhome motorhome8 = new Motorhome("Loki", "diesel", 8000, brand6);
        Motorhome motorhome9 = new Motorhome("Hela", "benzin", 9000, brand7);
        Motorhome motorhome10 = new Motorhome("Idun", "diesel", 10000, brand8);

        motorhomeService.saveMotorhome(motorhome1);
        motorhomeService.saveMotorhome(motorhome2);
        motorhomeService.saveMotorhome(motorhome3);
        motorhomeService.saveMotorhome(motorhome4);
        motorhomeService.saveMotorhome(motorhome5);
        motorhomeService.saveMotorhome(motorhome6);
        motorhomeService.saveMotorhome(motorhome7);
        motorhomeService.saveMotorhome(motorhome8);
        motorhomeService.saveMotorhome(motorhome9);
        motorhomeService.saveMotorhome(motorhome10);


        User user1 = new User("Barbara Santa", "Sales assistant", "55512131415", "Barbi", "1234");
        User user2 = new User("Monica Lewinsky", "Sales assistant", "55522232425", "Mona", "1111");
        User user3 = new User("Cindy Crawford", "Sales assistant", "55532333435", "Cindy", "0000");
        User user4 = new User("Mr. Robot", "Sales assistant", "55542434445", "Robi", "0123");
        User user5 = new User("John Doe", "Bookkeeper", "55582838485", "Johnny", "4321");

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
        userService.saveUser(user5);



        Season seasonLow = new Season("Low Season", 1);
        Season seasonMiddle = new Season("Middle Season", 1.3);
        Season seasonPeak = new Season("Peak Season", 1.6);


        seasonService.saveSeason(seasonLow);
        seasonService.saveSeason(seasonMiddle);
        seasonService.saveSeason(seasonPeak);


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

        Booking booking1 = new Booking("2022.05.05.", "2022.05.06.", "Køge", "Kastrup", "Mubby Mubibovich", "555-43536576", "Everland", "01234567", "12346543234567876543", motorhome1);
        Booking booking2 = new Booking("2022.11.11", "2022.12.12.", "Køge", "Kastrup", "Mubby Mubibovich", "555-43536576", "Everland", "01234567", "12346543234567876543", motorhome2);

        bookingService.saveBooking(booking1);
        bookingService.saveBooking(booking2);

    }
}
