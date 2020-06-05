package ru.altai.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigController {

    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping("/encode")
    @ResponseBody
    public String encodeString(@RequestParam String param) {
        return passwordEncoder.encode(param);
    }

}
