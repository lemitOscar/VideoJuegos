package com.Jesslim.VideoJuegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Jesslim.VideoJuegos.domain.VideoJuego;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


public interface VideojuegoRepository extends JpaRepository<VideoJuego, Integer> {

//    para buscar ordenado
    @Query("select v from VideoJuego v order by v.nombre")
    List<VideoJuego> buscarT();

    //buscar por distribuidor
    @Query("select v from VideoJuego v where v.distribuidor.id =?1 order by v.nombre")
    List<VideoJuego> buscarPorDistribuidorId(int distribuidorId);

    //para el buscador
    @Query("select v from VideoJuego v where v.nombre like %?1%")
    List<VideoJuego> buscarjuego(String palabraJ);
    
   

}
