package com.fshahy.app.orders.dto;

public class ProductDto {

    private long id;
    private String name;

    public ProductDto() {}

    public ProductDto(long id) {
        this.id = id;
    }

    public ProductDto(String id) {
        if(id != null && !id.trim().equals("")) {
            this.id = Long.parseLong(id);
        }
    }

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
