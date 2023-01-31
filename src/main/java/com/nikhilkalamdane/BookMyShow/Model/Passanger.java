package com.nikhilkalamdane.BookMyShow.Model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

enum Gender{
    MALE,
    FEMALE
}

public class Passanger {
    private int passangerId;
    private Date date;
    private int age;
    private Gender gender;

    @ManyToOne
    @JoinColumn
    private int trainId;
}
