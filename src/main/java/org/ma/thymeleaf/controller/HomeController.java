package org.ma.thymeleaf.controller;

import jakarta.persistence.Transient;
import org.ma.thymeleaf.entitie.Person;
import org.ma.thymeleaf.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
import java.util.UUID;

@Controller
public class HomeController {
    @Transient
    @Autowired
    private PersonRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("sinc", LocalTime.now());
        model.addAttribute("test", "oujda");
        return "home";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") Person person, Model model) {
        userRepository.save(person);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") UUID id, Model model) {
        userRepository.deleteById(id);
        return "redirect:/";
    }
}
