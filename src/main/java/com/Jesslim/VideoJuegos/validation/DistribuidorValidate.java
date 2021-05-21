package com.Jesslim.VideoJuegos.validation;

import com.Jesslim.VideoJuegos.domain.Distribuidor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



@Component
public class DistribuidorValidate implements Validator{

    /**
     * valide en una clase diferente pero se puede hacer como lo vengo haciendo
     * lo hice de esta manera para tener un orden solo valide un campo 
     * pero se pueden validar todos 
     */

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return Distribuidor.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        Distribuidor distribuidor = (Distribuidor)target;
        ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpty.distribuidor.nombre");
        
    }
    
}
