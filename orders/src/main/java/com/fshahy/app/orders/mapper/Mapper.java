package com.fshahy.app.orders.mapper;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class Mapper implements Serializable {

    @Produces
    private ModelMapper mapper;
    
    public Mapper() {
        this.mapper = new ModelMapper();
    }

}
