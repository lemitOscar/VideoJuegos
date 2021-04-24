package com.Jesslim.VideoJuegos.controller;

import com.Jesslim.VideoJuegos.domain.VideoJuego;
import com.Jesslim.VideoJuegos.service.DistribuidorService;
import com.Jesslim.VideoJuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideojuegoAbmController {

    private final DistribuidorService distribuidorService;
    private final VideojuegoService videojuegoService;

    public VideojuegoAbmController(DistribuidorService distribuidorService, VideojuegoService videojuegoService) {
        this.distribuidorService = distribuidorService;
        this.videojuegoService = videojuegoService;
    }

    @RequestMapping("/videojuego/crear")
    public String mostrarFormAlta(Model model) {
        model.addAttribute("distribuidores", distribuidorService.buscar());
//        asociar para guardar
        model.addAttribute("videojuego", new VideoJuego());
        return "formVideojuegos";
    }

    @PostMapping("/videojuego/guardar")
    public String guardarJuego(VideoJuego videojuego) {
        //System.out.println(videojuego);
        videojuegoService.guardarJuegito(videojuego);
        return "redirect:/";
    }

    @RequestMapping("/borrar")
    public String borrarJuegos(int idJuego) {
        videojuegoService.borrarJuego(idJuego);
        return "redirect:/";
    }

}
