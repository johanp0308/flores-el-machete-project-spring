package com.floreselmachetaso.jardineria.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/hola")
public class GenericoController {
    
    @GetMapping("/")
    public String getMethodName() {
        return new String("hola");
    }
    
}
