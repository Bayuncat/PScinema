package com.PSCinema.Controllers;

import com.PSCinema.models.Cinema;
import com.PSCinema.models.CinemaStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
    public class FrontController {

        @GetMapping("/")
        public String cinemaList(Model model) {
            model.addAttribute("cinemas", CinemaStorage.getCinemas());
            return "cinemaList";
        }

        @GetMapping("/create-form")
        public String createForm(@ModelAttribute("cinema") Cinema cinema) {
            return "create-form";
        }

        @PostMapping("/create")
        public String create(@ModelAttribute("cinema") Cinema cinema) {
            cinema.setId(UUID.randomUUID().toString());
            CinemaStorage.getCinemas().add(cinema);
            return "redirect:/";
        }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        Cinema cinemaToDelete = CinemaStorage.getCinemas().stream().
                filter(cinema -> cinema.getId().equals(id)).
                findFirst().
                orElseThrow(RuntimeException::new);
        CinemaStorage.getCinemas().remove(cinemaToDelete);
        return "redirect:/";
    }

    @GetMapping("/edit-form/{id}")
    public String createForm(@PathVariable("id") String id, Model model) {
        Cinema cinemaToEdit = CinemaStorage.getCinemas().stream().
                filter(cinema -> cinema.getId().equals(id)).
                findFirst().
                orElseThrow(RuntimeException::new);
        model.addAttribute("cinema", cinemaToEdit);
        return "edit-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("cinema") Cinema cinema) {
        delete(cinema.getId());
        CinemaStorage.getCinemas().add(cinema);
        return "redirect:/";
    }





}

