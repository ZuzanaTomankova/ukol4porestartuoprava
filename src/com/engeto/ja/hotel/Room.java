package com.engeto.ja.hotel;

import java.math.BigDecimal;

public class Room {
    private int number;
    private int numberOfBeds;
    private boolean balcony;
    private boolean seaView;
    public BigDecimal pricePerNight;

    public Room(int number, int numberOfBeds, boolean balcony, boolean seaView, BigDecimal pricePerNight) {
        this.number = number;
        this.numberOfBeds = numberOfBeds;
        this.balcony = balcony;
        this.seaView = seaView;
        this.pricePerNight = pricePerNight;
    }

    //region Přístupové metody


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    //endregion


    @Override
    public String toString() {
        return "Room " +
                "number=" + number +
                ", numberOfBeds=" + numberOfBeds +
                ", balcony=" + balcony +
                ", seaView=" + seaView +
                ", pricePerNight=" + pricePerNight
                ;
    }
}
