package com.fshahy.app.orders.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fshahy.app.orders.dto.SaleOrderDto;
import com.fshahy.app.orders.dto.SaleOrderLineDto;
import com.fshahy.app.orders.models.SaleOrder;
import com.fshahy.app.orders.models.SaleOrderLine;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class SaleOrderRepository {
    
    @PersistenceContext(unitName = "the-app-pu")
    private EntityManager entityManager;

    @Inject
    private ModelMapper modelMapper;

    public SaleOrderDto save(SaleOrderDto saleOrderDto) {
        SaleOrder saleOrder = this.modelMapper.map(saleOrderDto, SaleOrder.class);
        saleOrder.setCreated(LocalDate.now());
        entityManager.persist(saleOrder);
        return this.modelMapper.map(saleOrder, SaleOrderDto.class);
    }

    public List<SaleOrderDto> getAll() {
        return entityManager
                .createNamedQuery("SaleOrder.All", SaleOrder.class)
                .getResultStream()
                .map(so -> this.modelMapper.map(so, SaleOrderDto.class))
                .collect(Collectors.toUnmodifiableList());
    }

    public SaleOrderDto findById(Long id) {
        SaleOrder so = entityManager.find(SaleOrder.class, id);
        if (so != null) {
            return this.modelMapper.map(so, SaleOrderDto.class);
        }

        return null;
    }

    public boolean delete(Long id) {
        SaleOrder so = entityManager.find(SaleOrder.class, id);
        if (so != null) {
            entityManager.remove(so);
            return true;
        }
        return false;
    }

    public List<SaleOrderLineDto> findOrderLines(Long id) {
        SaleOrder so = entityManager.find(SaleOrder.class, id);
        if (so != null) {
            return so.getLines()
                    .stream()
                    .map(line -> this.modelMapper.map(line, SaleOrderLineDto.class))
                    .collect(Collectors.toUnmodifiableList());
        }
        return null;
    }

    public void saveLine(SaleOrderLineDto lineDto) {
        lineDto.setCreated(LocalDate.now());
        SaleOrderLine soLine = this.modelMapper.map(lineDto, SaleOrderLine.class);
        entityManager.persist(soLine);
    }
    
}
