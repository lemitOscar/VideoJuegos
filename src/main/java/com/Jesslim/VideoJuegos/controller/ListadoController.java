
package com.Jesslim.VideoJuegos.controller;

import com.Jesslim.VideoJuegos.domain.VideoJuego;
import com.Jesslim.VideoJuegos.service.VideojuegoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ListadoController {
    
    private final VideojuegoService videojuegoService;

    public ListadoController(VideojuegoService videojuegoservice) {
        this.videojuegoService = videojuegoservice;
    }
    
    
    @RequestMapping("/")
    public String listaVideoJuegos(Model model){
        List<VideoJuego> destacados = videojuegoService.buscarDestacado();
        model.addAttribute("videojuegos", destacados);
        //busqueda de video juegos
        return "listado";
    }
    
    @RequestMapping("/videojuegosDistribuidor")
    public String listaDeVideojuegosDistribuidor(int ditribuidorId, Model model){
        List<VideoJuego> juego = videojuegoService.buscarPorDistri(ditribuidorId);
        model.addAttribute("videojuegos", juego);
        return "listado";
    }
    
    @RequestMapping("/buscar")
    public String busqueda(Model model, @RequestParam("q") String palabraJ){
        List<VideoJuego> juego = videojuegoService.buscador(palabraJ);
        model.addAttribute("videojuegos", juego);
        return "listado";
    }
    
 
}
