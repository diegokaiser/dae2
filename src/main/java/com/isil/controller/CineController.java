package com.isil.controller;

import com.isil.service.CineService;
import org.springframework.stereotype.Controller;

@Controller
public class CineController {
    private final CineService cineService;

    public CineController(CineService cineService) {
        this.cineService = cineService;
    }


}
