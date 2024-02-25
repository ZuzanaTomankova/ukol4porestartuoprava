package com.engeto.ja.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    private List<Booking> bookingList = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }


    public Booking getBooking(int index) {
        return bookingList.get(index);
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookingList);
    }

    public void clearBookings() {
        bookingList.clear();
    }

    private double getAverageGuests() {
        System.out.println("-----------------------------------------------");
        System.out.println("Průměrný počet hostů na jednu rezervaci: " );
                double averageGuest = guestList.size() / (bookingList.size() +
                otherGuests.size());
        return averageGuest;


}
