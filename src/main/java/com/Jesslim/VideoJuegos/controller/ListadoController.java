package com.Jesslim.VideoJuegos.controller;

import com.Jesslim.VideoJuegos.domain.VideoJuego;
import com.Jesslim.VideoJuegos.service.VideojuegoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListadoController {

    @Autowired
    private VideojuegoService videojuegoService;

    //devuleve los distribuidores ordenados
    @RequestMapping("/")
    public String listaVideoJuegos(Model model) {
        List<VideoJuego> destacados = videojuegoService.buscarDestacado();
        model.addAttribute("videojuegos", destacados);
        //busqueda de video juegos
        return "listado";
    }

    //cuando selecciono un distribuidor y solo me muestra esos
    @RequestMapping("/videojuegosDistribuidor")
    public String listaDeVideojuegosDistribuidor(int ditribuidorId, Model model) {
        List<VideoJuego> juego = videojuegoService.buscarPorDistri(ditribuidorId);
        model.addAttribute("videojuegos", juego);
        return "listado";
    }

    //buscador de la barra
    @RequestMapping("/buscar")
    public String busqueda(Model model, @RequestParam("q") String palabraJ) {
        List<VideoJuego> juego = videojuegoService.buscador(palabraJ);
        if (juego == null) {
            return "noHayJuego";
        }
        model.addAttribute("videojuegos", juego);
        return "listado";
    }

}
