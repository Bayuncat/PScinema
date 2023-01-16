package com.PSCinema.models;

import java.util.ArrayList;
import java.util.List;

public class CinemaStorage {

    private static List<Cinema> cinemas = new ArrayList<>();

    public static List<Cinema> getCinemas(){
        return cinemas;

    }
}
