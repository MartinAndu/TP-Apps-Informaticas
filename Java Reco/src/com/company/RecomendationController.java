package com.company;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecomendationController {

    @RequestMapping("/recomendar")
    public Recomendator obtenerRecomendacion(@RequestParam(value="name", defaultValue="World") String name ) {
        // TODO: complete service
        return null;
    }
}
