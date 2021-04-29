package com.Jesslim.VideoJuegos;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoJuegosApplication {
    
      public static final Logger logger = LoggerFactory.getLogger(VideoJuegosApplication.class);
      
	public static void main(String[] args) {
		SpringApplication.run(VideoJuegosApplication.class, args);
                
              logger.info("INFO - soy el logger ando corriendo...");
	}
        
}
