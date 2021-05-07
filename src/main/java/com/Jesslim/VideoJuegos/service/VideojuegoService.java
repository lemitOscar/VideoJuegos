package com.Jesslim.VideoJuegos.service;

import com.Jesslim.VideoJuegos.domain.VideoJuego;

import com.Jesslim.VideoJuegos.repository.VideojuegoRepository;
import java.util.List;
import java.util.Optional;

import static com.Jesslim.VideoJuegos.VideoJuegosApplication.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VideojuegoService {

    // hay que inyectar dependencias
    @Autowired
    private VideojuegoRepository videojuegoRepository;

    // metodo de ejecuccion vergas que llama
    public List<VideoJuego> buscarDestacado() {
        return videojuegoRepository.buscarT();
    }

    // buscar por distribuidor
    public List<VideoJuego> buscarPorDistri(int distribuidorId) {
        return videojuegoRepository.buscarPorDistribuidorId(distribuidorId);
    }

    // metodo para buscar
    public List<VideoJuego> buscador(String palabraJ) {
        List<VideoJuego> juego = videojuegoRepository.buscarjuego(palabraJ);
        if (juego.isEmpty()) {
            return null;
        } else {
            return videojuegoRepository.buscarjuego(palabraJ);
        }
    }

    // metodo para guradar el juego
    public VideoJuego guardarJuegito(VideoJuego videoJuego) {
        return videojuegoRepository.save(videoJuego);
    }

    // metodo para borrar un juego
    public boolean borrarJuego(int idJuego) {
        boolean flag = false;

        try {
            videojuegoRepository.deleteById(idJuego);
            flag = true;
            logger.info("soy la bandera " + flag);

        } catch (Exception e) {
            throw new RuntimeException("no se encotro el id" + flag);
        }

        return flag;
    }

    // metodo para actualizar
    public VideoJuego obtenerId(int idJuegoa) {
        Optional<VideoJuego> optional = videojuegoRepository.findById(idJuegoa);
        VideoJuego videoJuego = null;
        if (optional.isPresent()) {
            videoJuego = optional.get();
        } else {
            throw new RuntimeException("no se encontro ningun id" + idJuegoa);
        }
        return videoJuego;
    }

    // para las paginacion
    public Page<VideoJuego> obtenerPagina(Pageable pageable) {
        return videojuegoRepository.findAll(pageable);
    }

}
