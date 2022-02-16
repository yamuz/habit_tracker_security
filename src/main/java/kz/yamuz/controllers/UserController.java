package kz.yamuz.controllers;

import kz.yamuz.domain.Role;
import kz.yamuz.domain.Status;
import kz.yamuz.domain.User;
import kz.yamuz.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    UserService userService;
    PasswordEncoder passwordEncoder;

    public UserController(UserService userService, @Qualifier("bcrypt12") PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser( User user, BindingResult result, Model model){ //TO DO - @Valid add
        if (result.hasErrors()) {
            System.out.println("user " + user.getEmail()+ " error while registering..");
            return "redirect:/register";
        }

        System.out.println("user " + user.getEmail()+ "/" + user.getEmail());
        if (userService.getUserByEmail(user.getEmail()) != null)
            return "redirect:/login";

        user.setStatus(Status.ACTIVE);
        user.setRole(Role.USER);
        String encoded = passwordEncoder.encode(user.getPassword());
        System.out.println("encoded:"+ encoded);
        user.setPassword(encoded);
        userService.saveUser(user);

        return "redirect:/login";
    }
}
