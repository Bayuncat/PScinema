package com.PSCinema;

import com.PSCinema.models.CinemaStorage;
import com.PSCinema.models.Cinema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


    @SpringBootApplication
    public class Application {

        public static void main(String[] args) {

            CinemaStorage.getCinemas().add(
                    new Cinema("1","Зеленая миля", 1999, "Фрэнк Дарабонт","драма"));

            CinemaStorage.getCinemas().add(
                    new Cinema("2", "Список Шиндлера", 1993, "Стивен Спилберг","драма"));

            CinemaStorage.getCinemas().add(
                    new Cinema("3", "Побег из Шоушенка", 1994, "Фрэнк Дарабонт","драма"));

            SpringApplication.run(Application.class, args);
        }

     }
