package com.ram.Football.Registration.Form;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/")
    public String showRegistrationForm(Model model) {
        model.addAttribute("player", new Player());
        return "register";
    }

    @PostMapping("/register")
    public String registerPlayer(@ModelAttribute("player") Player player) {
        playerRepository.save(player);
        return "redirect:/players";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // The form is located in register.html
    }

    @GetMapping("/players")
    public String viewPlayers(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "viewPlayers";
    }
}
