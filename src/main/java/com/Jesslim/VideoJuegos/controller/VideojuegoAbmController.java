package com.Jesslim.VideoJuegos.controller;

import static com.Jesslim.VideoJuegos.VideoJuegosApplication.logger;
import com.Jesslim.VideoJuegos.domain.VideoJuego;
import com.Jesslim.VideoJuegos.service.DistribuidorService;
import com.Jesslim.VideoJuegos.service.VideojuegoService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    //link para crear un juego
    @RequestMapping("/videojuego/crear")
    public String mostrarFormAlta(Model model) {
        model.addAttribute("distribuidores", distribuidorService.buscar());
        model.addAttribute("Objvideojuego", new VideoJuego());
        return "formVideojuegos";
    }

    //este ya es para guradar va enlazado con el anterior
    @PostMapping("/videojuego/guardar")
    public String guardarJuego(Model model, @Valid @ModelAttribute(name = "Objvideojuego")  VideoJuego Objvideojuego, BindingResult bindingResult) {
        // System.out.println(videojuego);
        model.addAttribute("distribuidores", distribuidorService.buscar());

        if (bindingResult.hasErrors()) {
            return "formVideojuegos";
        }
         videojuegoService.guardarJuegito(Objvideojuego);
        return "redirect:/";
    }

    //borrar un juego
    @RequestMapping("/borrar")
    public String borrarJuegos(int idJuego) {
        videojuegoService.borrarJuego(idJuego);
        return "redirect:/";
    }

//    link de actualizar un juego nomas
    @GetMapping("/actualizarJuego")
    public String actualiGame(Model model, int idJuegoa) {
        model.addAttribute("juegosA", videojuegoService.obtenerId(idJuegoa));
        model.addAttribute("distribuidores", distribuidorService.buscar());
        model.addAttribute("videojuego", new VideoJuego());
        return "listadoUpdate";
    }

}
