package com.engeto.ja.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    private Guest guest;
    private List<Guest> otherGuests;
    private int numberOfGuests;
    private LocalDate startOfStay;
    private LocalDate endOfStay;
    private boolean businessStay;

    public Booking(Room room, Guest guest, List<Guest> otherGuests, int numberOfGuests, LocalDate startOfStay, LocalDate endOfStay, boolean businessStay) {
        this.room = room;
        this.guest = guest;
        this.otherGuests = otherGuests;
        this.numberOfGuests = numberOfGuests;
        this.startOfStay = startOfStay;
        this.endOfStay = endOfStay;
        this.businessStay = businessStay;
    }
//region Přístupové metody

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public List<Guest> getOtherGuests() {
        return new ArrayList<>(otherGuests);
    }

    public void setOtherGuests(List<Guest> otherGuests) {
        this.otherGuests = otherGuests;

    }

    public LocalDate getStartOfStay() {
        return startOfStay;
    }

    public void setStartOfStay(LocalDate startOfStay) {
        this.startOfStay = startOfStay;
    }

    public LocalDate getEndOfStay() {
        return endOfStay;
    }

    public void setEndOfStay(LocalDate endOfStay) {
        this.endOfStay = endOfStay;
    }

    public boolean isBusinessStay() {
        return businessStay;
    }

    public void setBusinessStay(boolean businessStay) {
        this.businessStay = businessStay;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
//endregion

    public long getBookingLength(){
        long daysBetween = ChronoUnit.DAYS.between(startOfStay, endOfStay);
        return daysBetween;
    }

    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice = room.getPricePerNight().multiply(BigDecimal.valueOf(getBookingLength()));
        return totalPrice;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", guest=" + guest +
                ", otherGuests=" + otherGuests +
                ", numberOfGuests=" + numberOfGuests +
                ", startOfStay=" + startOfStay +
                ", endOfStay=" + endOfStay +
                ", businessStay=" + businessStay +
                '}';
    }
}
