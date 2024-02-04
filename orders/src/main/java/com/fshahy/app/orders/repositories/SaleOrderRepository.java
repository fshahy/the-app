package com.fshahy.app.orders.repositories;

import com.fshahy.app.orders.dto.SaleOrderDto;
import com.fshahy.app.orders.dto.SaleOrderLineDto;
import java.util.List;

import com.fshahy.app.orders.models.Customer;
import com.fshahy.app.orders.models.SaleOrder;
import com.fshahy.app.orders.models.SaleOrderLine;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Date;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@RequestScoped
public class SaleOrderRepository {
    
    @Inject
    private ModelMapper modelMapper;
    
    @PersistenceContext(unitName = "the-app-pu")
    private EntityManager entityManager;

    public SaleOrderDto save(SaleOrderDto saleOrderDto) {
        SaleOrder saleOrder = this.modelMapper.map(saleOrderDto, SaleOrder.class);
        Customer customer = entityManager.find(Customer.class, saleOrderDto.getCustomerId());
        SaleOrder so = new SaleOrder();
        so.setCustomer(customer);
        so.setCreated(new Date());
        entityManager.persist(so);
        entityManager.flush(); // because I need to load the id generated for entity
        return this.modelMapper.map(so, SaleOrderDto.class);
    }

    public List<SaleOrderDto> getAll() {
        return entityManager
                .createNamedQuery("SaleOrder.All", SaleOrder.class)
                .getResultStream()
                .map(so -> this.modelMapper.map(so, SaleOrderDto.class))
                .collect(Collectors.toUnmodifiableList());
    }

    public SaleOrderDto findById(long id) {
        SaleOrder so = entityManager.find(SaleOrder.class, id);
        if (so != null) {
            return this.modelMapper.map(so, SaleOrderDto.class);
        }

        return null;
    }

    public boolean delete(long id) {
        SaleOrder so = entityManager.find(SaleOrder.class, id);
        if (so != null) {
            entityManager.remove(so);
            return true;
        }
        return false;
    }

    public List<SaleOrderLineDto> findOrderLines(long id) {
        SaleOrder so = entityManager.find(SaleOrder.class, id);
        if (so != null) {
            return so.getLines()
                    .stream()
                    .map(line -> this.modelMapper.map(line, SaleOrderLineDto.class))
                    .collect(Collectors.toUnmodifiableList());
        }
        return null;
    }

    public void saveLine(long orderId, SaleOrderLineDto solDto) {
//        SaleOrder so = entityManager.find(SaleOrder.class, orderId);
        solDto.setOrderId(orderId);
        solDto.setCreated(new Date());
        SaleOrderLine soLine = this.modelMapper.map(solDto, SaleOrderLine.class);
        entityManager.persist(soLine);
    }
    
}
