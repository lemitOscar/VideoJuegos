package com.Jesslim.VideoJuegos.mvcConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("TiempoInterceptorHandler")
    private HandlerInterceptor tiempoHandler;

    @Autowired
    @Qualifier("horarioAtencion")
    private HandlerInterceptor horarioInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tiempoHandler).addPathPatterns("/");
        registry.addInterceptor(horarioInterceptor).excludePathPatterns("/cerrado");
    }

    // @Override
    // public void addInterceptor(InterceptorRegistry registry2){
    //     registry2.addInterceptor(horarioInterceptor).excludePathPatterns("/cerrado");
    // }
    
}
