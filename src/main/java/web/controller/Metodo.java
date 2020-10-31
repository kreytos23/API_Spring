package web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Saludar")
public class Metodo {

    @GetMapping("/Luis")
    public String saludo(){
        return "Te amo";
    }
}
