package com.Jesslim.VideoJuegos.controller;

import static com.Jesslim.VideoJuegos.VideoJuegosApplication.logger;
import com.Jesslim.VideoJuegos.domain.Distribuidor;
import com.Jesslim.VideoJuegos.service.DistribuidorService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DistribuidorController {

	@Autowired
	private DistribuidorService distribuidorService;

	// link formulario distribuidor
	@RequestMapping("/videojuego/crearDistribuidor")
	public String fornewDistribuidor(Model model) {
		model.addAttribute("distribuidor", new Distribuidor());
		return "formDistribuidor";
	}

	// metodo para insertar el distribuidor
	// en estos metodos valido de putazo
	@PostMapping("/videojuego/crearDistribuidor/save")
	public String forSaveDistribuidor(@Valid Distribuidor distribuidor, BindingResult result) {
		if (result.hasErrors()) {
//            logger.info("si llego hasta aqui");
			return "formDistribuidor";
		}
		distribuidorService.insertarDis(distribuidor);
		return "redirect:/videojuego/listaDistribuidor";

	}

	// metodo para listar los distriubidores
	@RequestMapping("/videojuego/listaDistribuidor")
	public String listarDistribuidor(Model model) {
		List<Distribuidor> lisDist = distribuidorService.buscar();
		model.addAttribute("lisDist", lisDist);
		return "listaDistribuidor";
	}

	// borrar un distribuidor
	@RequestMapping("/deleteDistribuidor")
	public String rDeleteDistri(int idDis) {
		distribuidorService.borrarDistribuidor(idDis);
		return "redirect:/videojuego/listaDistribuidor";
	}

	// update distribuidor
	@GetMapping("/updateDistribuidor")
	public String rUpdateDistri(int idDisA, Model model) {
		model.addAttribute("distribuidor", distribuidorService.idActualizarD(idDisA));
		return "forDistribuidorUpdate";
	}

}
