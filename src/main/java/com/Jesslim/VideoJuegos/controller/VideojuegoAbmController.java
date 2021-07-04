package com.Jesslim.VideoJuegos.controller;

import com.Jesslim.VideoJuegos.domain.VideoJuego;
import com.Jesslim.VideoJuegos.service.DistribuidorService;
import com.Jesslim.VideoJuegos.service.VideojuegoService;

import java.util.ArrayList;

import static com.Jesslim.VideoJuegos.VideoJuegosApplication.logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VideojuegoAbmController {

    @Autowired
    private DistribuidorService distribuidorService;
    @Autowired
    private VideojuegoService videojuegoService;

    // link para crear un juego
    @RequestMapping("/videojuego/crear")
    public String mostrarFormAlta(Model model) {
        model.addAttribute("distribuidores", distribuidorService.buscar());
        model.addAttribute("Objvideojuego", new VideoJuego());
        return "formVideojuegos";
    }

    // este ya es para guradar va enlazado con el anterior
    @PostMapping("/videojuego/guardar")
    public String guardarJuego(Model model, @Valid @ModelAttribute(name = "Objvideojuego") VideoJuego Objvideojuego,
            BindingResult bindingResult, RedirectAttributes flash) {
        // System.out.println(videojuego);
        model.addAttribute("distribuidores", distribuidorService.buscar());
        flash.addFlashAttribute("success", "El juego se guardo corectamente");
        if (bindingResult.hasErrors()) {
            return "formVideojuegos";
        }
        videojuegoService.guardarJuegito(Objvideojuego);
        return "redirect:/videojuego/crear";
    }

    // link de actualizar un juego nomas
    @GetMapping("/actualizarJuego")
    public String actualiGame(Model model, int idJuegoa) {
        model.addAttribute("Objvideojuego", videojuegoService.obtenerId(idJuegoa));
        model.addAttribute("distribuidores", distribuidorService.buscar());
        // model.addAttribute("videojuego", new VideoJuego());
        return "listadoUpdate";
    }

    // borrar un juego
    @GetMapping("/borrar")
    public String borrarJuegos(int idJuego, int pagi, @RequestParam ArrayList<String> videoj, Model model) {

        // for (String s : videoj) {
        // logger.info("" + s);
        // logger.info("---------------");
        // }
        logger.info("---------------" + videoj.size());
        // videojuegoService.borrarJuego(idJuego);

        if (videoj.size() == 7) {
            videojuegoService.borrarJuego(idJuego);
            return "redirect:/";
        } else {
            videojuegoService.borrarJuego(idJuego);
            return "redirect:/?page=" + pagi;
        }

        // return "redirect:/";

    }


    @RequestMapping("/cerrado")
    public String cerrarhorario(){
        return "pagecerrar";
    }

}
