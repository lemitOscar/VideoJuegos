package com.Jesslim.VideoJuegos.controller;

import com.Jesslim.VideoJuegos.domain.VideoJuego;
import com.Jesslim.VideoJuegos.service.VideojuegoService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListadoController {

	@Autowired
	private VideojuegoService videojuegoService;

	// devuleve los distribuidores ordenados
//    @RequestMapping("/")
//    public String listaVideoJuegos(Model model) {
//        List<VideoJuego> destacados = videojuegoService.buscarDestacado();
//        model.addAttribute("videojuegos", destacados);
//        //busqueda de video juegos
//        return "listado";
//    }

	// cuando selecciono un distribuidor y solo me muestra esos
	@RequestMapping("/videojuegosDistribuidor")
	public String listaDeVideojuegosDistribuidor(int ditribuidorId, Model model) {
		List<VideoJuego> juego = videojuegoService.buscarPorDistri(ditribuidorId);
		model.addAttribute("videojuegos", juego);
		return "listado";
	}

	// buscador de la barra
	@RequestMapping("/buscar")
	public String busqueda(Model model, @RequestParam("q") String palabraJ) {
		List<VideoJuego> juego = videojuegoService.buscador(palabraJ);
		if (juego == null) {
			return "noHayJuego";
		} else if (palabraJ.equalsIgnoreCase("")) {
			return "redirect:/";
		}
		// operador ternario
		model.addAttribute("videojuegos", juego);
		return "listado";
	}

	// metodo para la paginacion
	@GetMapping("/")
	public String findAll(@RequestParam Map<String, Object> params, Model model) {
		//int page = params.get("page")!= null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
	    int page;
		if (params.get("page") != null) {
			//para que inicie en la pagina 1
			page = Integer.valueOf(params.get("page").toString()) -1;
		}else { 
			page = 0;
		}
		//definir el tamñano de la pagina
		PageRequest pageRequest = PageRequest.of(page, 4); // pagina y tamaño
		//hago la inyeccion para traer la pagina
		Page<VideoJuego> pageVideoJuego = videojuegoService.obtenerPagina(pageRequest);
		// en una variable aviento las paginas
		int totalPage = pageVideoJuego.getTotalPages();
		// si las paginas son mayor a cero entonces
		if (totalPage > 0) {
			//genero las paginaciones es decir los numeros
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			//las mando a la lista
			model.addAttribute("pages", pages);
		}
		model.addAttribute("videojuegos", pageVideoJuego.getContent());
		model.addAttribute("actual", page + 1);
		model.addAttribute("siguiente", page + 2);
		model.addAttribute("atras", page);
		model.addAttribute("ultima", totalPage);
		return "listado";
	}

}
