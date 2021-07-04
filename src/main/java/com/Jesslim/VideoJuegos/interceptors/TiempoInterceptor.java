package com.Jesslim.VideoJuegos.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



@Component("TiempoInterceptorHandler")
public class TiempoInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TiempoInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
        long tiempofin = System.currentTimeMillis();
        long tiempoinicio = (Long) request.getAttribute("tiempotras");
        long tiempoTranscurridof = tiempofin-tiempoinicio;
        if (modelAndView != null) {
            modelAndView.addObject("tiempoTranscurridof", tiempoTranscurridof);
        }
        logger.info("entrando posthandler()....");
        logger.info("tiempo transcurrido: "+tiempoTranscurridof);
        
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("entrando preHandle()....");
        long tiempotras = System.currentTimeMillis();
        request.setAttribute("tiempotras", tiempotras);
        Random random = new Random();
        Thread.sleep(random.nextInt(500));
        return true;
    }
    
}
