package com.Jesslim.VideoJuegos.controller;

import static com.Jesslim.VideoJuegos.VideoJuegosApplication.logger;
import com.Jesslim.VideoJuegos.domain.Distribuidor;
import com.Jesslim.VideoJuegos.service.DistribuidorService;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DistribuidorController {

    private final DistribuidorService distribuidorService;

    public DistribuidorController(DistribuidorService distribuidorService) {
        this.distribuidorService = distribuidorService;
    }

    //link formulario distribuidor
    @RequestMapping("/videojuego/crearDistribuidor")
    public String fornewDistribuidor(Model model) {
        
        
        model.addAttribute("distribuidor", new Distribuidor());
        return "formDistribuidor";
    }

    //metodo para insertar el distribuidor
    //en estos metodos valido de putazo
    @PostMapping("/videojuego/crearDistribuidor/save")
    public String forSaveDistribuidor(@Valid Distribuidor distribuidor, BindingResult result) {
        if (result.hasErrors()) {
//            logger.info("si llego hasta aqui");
            return "formDistribuidor";
        }
        distribuidorService.insertarDis(distribuidor);
        return "redirect:/";

    }

}
