package com.engeto.ja.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    private List<Booking> bookingList = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookingList.remove(booking);
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookingList);
    }

    public void clearBookings(Booking booking) {
        bookingList.clear();
    }

    // public int getNumberOfWorkingBookings(){       toto mi nechodí
    //    bookingList.size();
    //  }

    public void getAverageGuests(Booking booking) {

    }
}
