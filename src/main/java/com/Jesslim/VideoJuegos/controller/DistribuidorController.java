/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Jesslim.VideoJuegos.controller;

import com.Jesslim.VideoJuegos.domain.Distribuidor;
import com.Jesslim.VideoJuegos.service.DistribuidorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Oscar
 */
@Controller
public class DistribuidorController {
    
    
    private final DistribuidorService distribuidorService;
 
    public DistribuidorController(DistribuidorService distribuidorService) {
        this.distribuidorService = distribuidorService;
    }
    
    //link formulario distribuidor
    @RequestMapping("/videojuego/crearDistribuidor")
    public String fornewDistribuidor(Model model){
        model.addAttribute("MoDdistri", new Distribuidor());
        return "formDistribuidor";
    }
        //metodo para insertar el distribuidor
    @PostMapping("/videojuego/crearDistribuidor/save")
    public String forSaveDistribuidor(Distribuidor distribuidor){
        distribuidorService.insertarDis(distribuidor);
           return "redirect:/";
    }

}