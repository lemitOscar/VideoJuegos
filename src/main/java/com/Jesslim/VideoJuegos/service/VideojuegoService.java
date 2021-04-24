package com.Jesslim.VideoJuegos.service;

import com.Jesslim.VideoJuegos.domain.VideoJuego;

import com.Jesslim.VideoJuegos.repository.VideojuegoRepository;
import java.util.List;
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
    public List<VideoJuego> buscarPorDistri(int distribuidorId){
        return videojuegoRepository.buscarPorDistribuidorId(distribuidorId);
    }
    
    //metodo para buscar
    public List<VideoJuego> buscador(String palabraJ){
        return videojuegoRepository.buscarjuego(palabraJ);
    }
    
    //metodo para guradar el juego
    public VideoJuego guardarJuegito(VideoJuego videoJuego){
        return videojuegoRepository.save(videoJuego);
    }
    
    //metodo para borrar un juego
    public void borrarJuego(int idJuego){
         videojuegoRepository.deleteById(idJuego);
    }
}
