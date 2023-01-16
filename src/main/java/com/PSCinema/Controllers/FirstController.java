package com.PSCinema.Controllers;

import com.PSCinema.models.CinemaStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static java.lang.String.format;

@RestController
public class FirstController {
//
//    @GetMapping("/")
//    public String index() {
//        return "Welcome to a best film collection";
//    }

    @RequestMapping("/cinemas")
    public String cinema() {
        return CinemaStorage.getCinemas().
                stream().
                map(cinema -> format("%s - %s - %s -%s", cinema.getName(), cinema.getYear(), cinema.getAuthor(), cinema.getGenre())).
                collect(Collectors.joining("</br>"));
    }
}
