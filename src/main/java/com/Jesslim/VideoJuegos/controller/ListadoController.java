
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
    
    private final VideojuegoService videojuegoservice;

    public ListadoController(VideojuegoService videojuegoservice) {
        this.videojuegoservice = videojuegoservice;
    }
    
    
    @RequestMapping("/")
    public String listaVideoJuegos(Model model){
        List<VideoJuego> destacados = videojuegoservice.buscarDestacado();
        model.addAttribute("videojuegos", destacados);
        //busqueda de video juegos
        return "listado";
    }
    
    @RequestMapping("/videojuegosDistribuidor")
    public String listaDeVideojuegosDistribuidor(int ditribuidorId, Model model){
        List<VideoJuego> juego = videojuegoservice.buscarPorDistri(ditribuidorId);
        model.addAttribute("videojuegos", juego);
        return "listado";
    }
    
    @RequestMapping("/buscar")
    public String busqueda(Model model, @RequestParam("q") String palabraJ){
        List<VideoJuego> juego = videojuegoservice.buscador(palabraJ);
        model.addAttribute("videojuegos", juego);
        return "listado";
    }
    
 
}
