package kz.yamuz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/auth/success")
    public String getSuccessPage() {
        return "auth/success";
    }




}
