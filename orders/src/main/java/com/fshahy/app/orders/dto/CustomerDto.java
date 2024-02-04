package com.fshahy.app.orders.dto;

public class CustomerDto {
    
    private long id;
    private String name;
    
    public CustomerDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
