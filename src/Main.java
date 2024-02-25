import com.engeto.ja.hotel.Booking;


import com.engeto.ja.hotel.BookingManager;
import com.engeto.ja.hotel.Guest;
import com.engeto.ja.hotel.Room;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guest guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest("Jan", "Dvořáček", LocalDate.of(1995, 5, 5));
        Guest guest3 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
        Guest guest4 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
        Guest guest5 = new Guest("Karolína", "Tmavá", LocalDate.of(2000, 1, 1));

        List<Guest> otherGuests = new ArrayList<>();
        otherGuests.add(guest2);


        List<Guest> guestList = new ArrayList<>();
        guestList.add(guest1);
        guestList.add(guest2);
        guestList.add(guest3);
        guestList.add(guest4);
        guestList.add(guest5);


        Room room1 = new Room(1, 1, true, true, BigDecimal.valueOf(1000));
        Room room2 = new Room(2, 1, true, true, BigDecimal.valueOf(1000));
        Room room3 = new Room(3, 3, false, true, BigDecimal.valueOf(2400));

        BookingManager bookingManager = new BookingManager();
        fillBookings(bookingManager, room1, guest1, room3, otherGuests, guest3, room2, guest4, guest5);


        List<Booking> bookingList = bookingManager.getBookings();

        getNumberOfWorkingBookings(bookingList);

        printEightFirst(bookingList);

        bookingManager.getAverageGuests();


        System.out.println("-----------------------------------------------");
        System.out.println("Výpis všech rezervací: ");
        for (Booking booking : bookingList) {
            System.out.println( booking.getStartOfStay() + "  až  " + booking.getEndOfStay() + " "+booking.getGuest()+
                    "["+ booking.getNumberOfGuests()+", "+booking.getRoom()+" ]  "+booking.getTotalPrice()+"Kč");


        }


        printGuestStatistics(bookingList);


    }

    private static void fillBookings(BookingManager bookingManager, Room room1, Guest guest1, Room room3, List<Guest> otherGuests, Guest guest3, Room room2, Guest guest4, Guest guest5) {
        bookingManager.addBooking(new Booking(room1, guest1, null, 1, LocalDate.of(2021, 7, 19),
                LocalDate.of(2021, 7, 26), true));
        bookingManager.addBooking(new Booking(room3, guest1, otherGuests, 2, LocalDate.of(2021, 7, 19),
                LocalDate.of(2021, 7, 26), true));
        bookingManager.addBooking(new Booking(room3, guest3, null, 1, LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 9, 14), true));
        bookingManager.addBooking(new Booking(room2, guest4, null, 1, LocalDate.of(2023, 7, 18),
                LocalDate.of(2023, 7, 21), false));

        for (int i = 1; i <= 20; i = i + 2) {
            bookingManager.addBooking(new Booking(room2, guest5, null, 1, LocalDate.of(2023, 8, i),
                    LocalDate.of(2023, 8, i + 1), false));
        }

        bookingManager.addBooking(new Booking(room3, guest5, null, 1, LocalDate.of(2023, 8, 1),
                LocalDate.of(2023, 8, 31), false));
    }

    private static void printGuestStatistics(List<Booking> bookingList) {
        List<Booking> oneGuestList = new ArrayList<>();
        List<Booking> twoGuestList = new ArrayList<>();
        List<Booking> threeGuestList = new ArrayList<>();

        for (Booking booking : bookingList) {
            if (booking.getNumberOfGuests()==1) oneGuestList.add(booking);
            else if
            (booking.getNumberOfGuests()==2) twoGuestList.add(booking);
            else
                threeGuestList.add(booking);}


        System.out.println("---------------------------------------");
        System.out.println("Statistika hostů:");
        System.out.println("Počet rezervací s jedním hostem: "+ oneGuestList.size());
        System.out.println("Počet rezervací se dvěma hosty: "+twoGuestList.size());
        System.out.println("Počet rezervací se třemi a více hosty: "+ threeGuestList.size());
    }



    private static void getNumberOfWorkingBookings(List<Booking> bookingList) {
        List<Booking> businessStay = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (!booking.isBusinessStay()) businessStay.add(booking);}
        System.out.println("Počet pracovních pobytů: " +businessStay.size());
    }

    private static void printEightFirst(List<Booking> bookingList) {
        System.out.println("----------------------------");
        System.out.println("Prvních osum hostů rekreačního pobytu: ");

        List<Booking> holidayStay = new ArrayList<>();
        for (Booking booking : bookingList) {
            if (!booking.isBusinessStay()) holidayStay.add(booking);}

        for (int i = 1; i <= 8; i = i + 1) {
            System.out.println("Rekreační pobyt: "+holidayStay.get(i));
        }
    }


}
