package com.Jesslim.VideoJuegos.service;

import com.Jesslim.VideoJuegos.domain.Distribuidor;
import com.Jesslim.VideoJuegos.repository.DistribuidorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DistribuidorService {

    private final DistribuidorRepository distribuidorRepository;

    public DistribuidorService(DistribuidorRepository distribuidorRepository) {
        this.distribuidorRepository = distribuidorRepository;
    }


    //metodo para buscar de manera ordenada
    public List<Distribuidor> buscar(){
        return distribuidorRepository.buscarDisOrder();
    }
    //metodo para insertar un nuevo distribuidor
    public Distribuidor insertarDis(Distribuidor distribuidor){
        return distribuidorRepository.save(distribuidor);
    }
    
}
