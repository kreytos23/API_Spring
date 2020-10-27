package web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class Metodo {

    @GetMapping("/Manu")
    public String saludo(){
        return "Chupas";
    }
}
