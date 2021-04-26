package com.Jesslim.VideoJuegos.service;

import com.Jesslim.VideoJuegos.domain.VideoJuego;

import com.Jesslim.VideoJuegos.repository.VideojuegoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class VideojuegoService {

    //hay que inyectar dependencias
    private final VideojuegoRepository videojuegoRepository;

    public VideojuegoService(VideojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }

    //metodo de ejecuccion vergas que llama
    public List<VideoJuego> buscarDestacado() {
        return videojuegoRepository.buscarT();
    }

    //buscar por distribuidor
    public List<VideoJuego> buscarPorDistri(int distribuidorId) {
        return videojuegoRepository.buscarPorDistribuidorId(distribuidorId);
    }

    //metodo para buscar
    public List<VideoJuego> buscador(String palabraJ) {
        List<VideoJuego> juego = videojuegoRepository.buscarjuego(palabraJ);
        if (juego.isEmpty()) {
            return null;
        }else{
            return videojuegoRepository.buscarjuego(palabraJ);
        }
        
    }

    //metodo para guradar el juego
    public VideoJuego guardarJuegito(VideoJuego videoJuego) {
        return videojuegoRepository.save(videoJuego);
        
    }

    //metodo para borrar un juego
    public void borrarJuego(int idJuego) {
        videojuegoRepository.deleteById(idJuego);
    }
    
    //metodo para actualizar
    public VideoJuego obtenerId(int idJuegoa){
        Optional<VideoJuego> optional = videojuegoRepository.findById(idJuegoa);
        VideoJuego videoJuego = null;
        if (optional.isPresent()) {
            videoJuego = optional.get();
        }else{
            throw new RuntimeException("no se encontro ningun id"+idJuegoa);
        }
        return videoJuego;
    }


}
