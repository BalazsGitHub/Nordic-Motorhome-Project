
package teletearbies.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import teletearbies.entity.*;
import teletearbies.service.*;

import javax.annotation.PostConstruct;
import java.util.*;

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

    @Autowired
    private ExtraService extraService;

    //the @PostConstruct annotation is used on a method that needs to be executed after dependency injection is done to perform any initialization.
    // It is used to set up configuration before initializing bean (in our case, will first initialize the @Autowired services above,
    // then will run the method below the @postConstruct

    //@PostConstruct
    public void initialiseDatabase() {

        Brand brand1 = new Brand("American coach", "Eagle", 300, 12);
        Brand brand2 = new Brand("American coach", "Dream", 300, 12);
        Brand brand3 = new Brand("Jayco", "Alante", 250, 10);
        Brand brand4 = new Brand("Jayco", "Embark", 250, 10);
        Brand brand5 = new Brand("Fleetwood RV", "Discovery", 200, 8);
        Brand brand6 = new Brand("Fleetwood RV", "Southwind", 150, 6);
        Brand brand7 = new Brand("Mercedes-benz", "Hymer B-class", 125, 4);
        Brand brand8 = new Brand("Mercedes-benz", "Hymer Exsis", 100, 3);

        brandService.saveBrand(brand1);
        brandService.saveBrand(brand2);
        brandService.saveBrand(brand3);
        brandService.saveBrand(brand4);
        brandService.saveBrand(brand5);
        brandService.saveBrand(brand6);
        brandService.saveBrand(brand7);
        brandService.saveBrand(brand8);

        Motorhome motorhome1 = new Motorhome("Ymir", "benzin", 1000, brand1, true);
        Motorhome motorhome2 = new Motorhome("Heimdal", "diesel", 2000, brand2, true);
        Motorhome motorhome3 = new Motorhome("Odin", "benzin", 3000, brand3, true);
        Motorhome motorhome4 = new Motorhome("Thor", "diesel", 4000, brand4, true);
        Motorhome motorhome5 = new Motorhome("Vidar", "benzin", 5000, brand3, true);
        Motorhome motorhome6 = new Motorhome("Freja", "diesel", 6000, brand4, true);
        Motorhome motorhome7 = new Motorhome("Tyr", "benzin", 7000, brand5, true);
        Motorhome motorhome8 = new Motorhome("Loki", "diesel", 8000, brand6, true);
        Motorhome motorhome9 = new Motorhome("Hela", "benzin", 9000, brand7, true);
        Motorhome motorhome10 = new Motorhome("Idun", "diesel", 10000, brand8, true);
        Motorhome motorhome11 = new Motorhome("Fenrir", "benzin", 10000, brand8, true);
        Motorhome motorhome12 = new Motorhome("Baldur", "diesel", 10000, brand8,  true);
        Motorhome motorhome13 = new Motorhome("Sleipnir", "diesel", 10000, brand8, true);
        Motorhome motorhome14 = new Motorhome("Jord", "benzin", 10000, brand8, true);
        Motorhome motorhome15 = new Motorhome("Frigg", "diesel", 1000, brand2, true);
        Motorhome motorhome16 = new Motorhome("Mimir", "benzin", 1700, brand8, true);
        Motorhome motorhome17 = new Motorhome("Vili", "benzin", 1800, brand5, true);
        Motorhome motorhome18 = new Motorhome("Ve", "diesel", 10870, brand8, true);
        Motorhome motorhome19 = new Motorhome("Aegir", "benzin", 14560, brand8, true);
        Motorhome motorhome20 = new Motorhome("Njord", "diesel", 1090, brand8, true);
        Motorhome motorhome21 = new Motorhome("Forseti", "benzin", 1100, brand5, true);
        Motorhome motorhome22 = new Motorhome("Audumbla", "benzin", 4500, brand8, false);
        Motorhome motorhome23 = new Motorhome("Skadi", "diesel", 12000, brand3, false);
        Motorhome motorhome24 = new Motorhome("Bragi", "benzin", 13000, brand8, true);
        Motorhome motorhome25 = new Motorhome("Sif", "diesel", 6000, brand1, true);
        Motorhome motorhome26 = new Motorhome("Ullr", "benzin", 6500, brand8, true);
        Motorhome motorhome27 = new Motorhome("Bestla", "diesel", 5400, brand2, true);
        Motorhome motorhome28 = new Motorhome("Hoenir", "benzin", 15000, brand7, true);
        Motorhome motorhome29 = new Motorhome("Buri", "diesel", 10060, brand6, true);
        Motorhome motorhome30 = new Motorhome("Magni", "benzin", 15000, brand8, true);
        Motorhome motorhome31 = new Motorhome("Thrud", "diesel", 18000, brand4, false);
        Motorhome motorhome32 = new Motorhome("Modi", "benzin", 10800, brand8, true);

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
        motorhomeService.saveMotorhome(motorhome11);
        motorhomeService.saveMotorhome(motorhome12);
        motorhomeService.saveMotorhome(motorhome13);
        motorhomeService.saveMotorhome(motorhome14);
        motorhomeService.saveMotorhome(motorhome15);
        motorhomeService.saveMotorhome(motorhome16);
        motorhomeService.saveMotorhome(motorhome17);
        motorhomeService.saveMotorhome(motorhome18);
        motorhomeService.saveMotorhome(motorhome19);
        motorhomeService.saveMotorhome(motorhome20);
        motorhomeService.saveMotorhome(motorhome21);
        motorhomeService.saveMotorhome(motorhome22);
        motorhomeService.saveMotorhome(motorhome23);
        motorhomeService.saveMotorhome(motorhome24);
        motorhomeService.saveMotorhome(motorhome25);
        motorhomeService.saveMotorhome(motorhome26);
        motorhomeService.saveMotorhome(motorhome27);
        motorhomeService.saveMotorhome(motorhome28);
        motorhomeService.saveMotorhome(motorhome29);
        motorhomeService.saveMotorhome(motorhome30);
        motorhomeService.saveMotorhome(motorhome31);
        motorhomeService.saveMotorhome(motorhome32);


        User user1 = new User("Barbara Santa", "Sales assistant", "555121314", "Barbi", "1234");
        User user2 = new User("Monica Lewinsky", "Sales assistant", "555222324", "Mona", "1111");
        User user3 = new User("Cindy Crawford", "Sales assistant", "555323334", "Cindy", "0000");
        User user4 = new User("Mr. Robot", "Sales assistant", "555424344", "Robi", "0123");
        User user5 = new User("John Doe", "Bookkeeper", "555828384", "Johnny", "4321");
        User user6 = new User("Tom Cruise", "Auto mechanic", "4587362739", "scientology", "9876");
        User user7 = new User("Douglas Beaver", "Owner", "4539495867", "db", "3579");

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
        userService.saveUser(user5);
        userService.saveUser(user6);
        userService.saveUser(user7);


        Season seasonLow = new Season("Low Season", 1);
        Season seasonMiddle = new Season("Middle Season", 1.3);
        Season seasonPeak = new Season("Peak Season", 1.6);


        seasonService.saveSeason(seasonLow);
        seasonService.saveSeason(seasonMiddle);
        seasonService.saveSeason(seasonPeak);


        Cancellation cancellation1 = new Cancellation("No cancellation", 100.00);
        Cancellation cancellation2 = new Cancellation("50 days", 20.00);
        Cancellation cancellation3 = new Cancellation("49-15 days", 50.00);
        Cancellation cancellation4 = new Cancellation("14-1 days", 80.00);
        Cancellation cancellation5 = new Cancellation("On rental day", 95.00);

        cancellationService.saveCancellation(cancellation1);
        cancellationService.saveCancellation(cancellation2);
        cancellationService.saveCancellation(cancellation3);
        cancellationService.saveCancellation(cancellation4);
        cancellationService.saveCancellation(cancellation5);


        Extra extra1 = new Extra("bike rack", 25);
        Extra extra2 = new Extra("bed linen", 10);
        Extra extra3 = new Extra("bicycle", 40);
        Extra extra4 = new Extra("parasol", 12);
        Extra extra5 = new Extra("trailer", 30);
        Extra extra6 = new Extra("picnic chair", 25);
        Extra extra7 = new Extra("picnic table", 30);
        Extra extra8 = new Extra("beach towel", 5);

        extraService.saveExtra(extra1);
        extraService.saveExtra(extra2);
        extraService.saveExtra(extra3);
        extraService.saveExtra(extra4);
        extraService.saveExtra(extra5);
        extraService.saveExtra(extra6);
        extraService.saveExtra(extra7);
        extraService.saveExtra(extra8);

        Set<Extra> extrasList = new HashSet<>();
        extrasList.add(extra1);
        extrasList.add(extra2);
        extrasList.add(extra3);
        extrasList.add(extra4);
        extrasList.add(extra5);
        extrasList.add(extra6);

        Booking booking1 = new Booking( "Køge", "Kastrup", "Mubby Mubibovich", "555-43536576", "Otatop 32", "48374653", "9872349873454328733", motorhome1, extrasList, cancellation1, user1, seasonLow);
        Booking booking2 = new Booking("Kastrup", "Kastrup", "Bogi Wogikan", "456-85764572", "Everland 1", "01234567", "12346543234567876543", motorhome2, extrasList, cancellation1, user2, seasonPeak);
        Booking booking3 = new Booking("Billund", "Kastrup", "Fe Buffelion", "45 34789567", "Cucumbala 43", "98762344", "5467893200398754783", motorhome3, extrasList, cancellation1, user3, seasonMiddle);
        Booking booking4 = new Booking("Kastrup", "Kastrup", "Dani Banman", "45987234982", "Orbanland 67", "908746372", "4839273847563728837", motorhome4, extrasList, cancellation1, user4, seasonPeak);

        bookingService.saveBooking(booking1);
        bookingService.saveBooking(booking2);
        bookingService.saveBooking(booking3);
        bookingService.saveBooking(booking4);
    }
}
