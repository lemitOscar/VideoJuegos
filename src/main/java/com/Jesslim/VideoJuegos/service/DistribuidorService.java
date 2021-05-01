package com.Jesslim.VideoJuegos.service;

import com.Jesslim.VideoJuegos.domain.Distribuidor;
import com.Jesslim.VideoJuegos.repository.DistribuidorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//estos se llaman estereotipos

@Service
public class DistribuidorService {

    @Autowired
    private DistribuidorRepository distribuidorRepository;

    //metodo para buscar de manera ordenada    //metodo que resgresa la lista de distribuidores ordenada
    public List<Distribuidor> buscar() {
        return distribuidorRepository.buscarDisOrder();
    }

    //metodo para insertar un nuevo distribuidor
    public Distribuidor insertarDis(Distribuidor distribuidor) {
        return distribuidorRepository.save(distribuidor);
    }

    //metodo para borrar un distribuidor
    public void borrarDistribuidor(int idDis) {
        distribuidorRepository.deleteById(idDis);
    }

    //metodo para actualizar un distribuidor
    public Distribuidor idActualizarD(int idDisA) {

        Optional<Distribuidor> optional = distribuidorRepository.findById(idDisA);
        Distribuidor distribuidor = null;
        if (optional.isPresent()) {
            distribuidor = optional.get();
        }else{
            throw new RuntimeException("no se encotro el id"+idDisA);
        }
        return distribuidor;
                
    }

}
