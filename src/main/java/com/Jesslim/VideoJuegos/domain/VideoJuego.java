package com.Jesslim.VideoJuegos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
//para hacer el orm 

@Entity
@Table(name = "videojuego")
public class VideoJuego {

    //para conectar con jpa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty()
    private String nombre;
    @NotEmpty
    private String descripcion;
    @NotEmpty
    private String imagenUrl;
    
    @NotNull
    @ManyToOne
    private Distribuidor distribuidor;
    //distribuidor_id

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //del distribuidor
    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

   
    
    
    
    
    
    
    @Override
    public String toString() {
        return "VideoJuego{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagenUrl=" + imagenUrl + ", distribuidor=" + distribuidor + '}';
    }

}
