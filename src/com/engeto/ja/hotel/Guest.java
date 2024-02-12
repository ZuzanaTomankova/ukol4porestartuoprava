package com.engeto.ja.hotel;

import java.time.LocalDate;

public class Guest {
    private String name;
    private String surname;
    private LocalDate birth;

    public Guest(String name, String surname, LocalDate birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    //region Přístupové metody


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    //endregion


    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
