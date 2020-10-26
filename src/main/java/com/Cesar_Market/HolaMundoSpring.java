package com.Cesar_Market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaMundoSpring {

    @GetMapping("/hola")
    public String saludar(){
        return "Hola Spring";
    }
}
