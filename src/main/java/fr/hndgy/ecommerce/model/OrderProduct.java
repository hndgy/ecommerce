package fr.hndgy.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderProduct {
    
    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(nullable = false)
    private Integer quantity;

    public OrderProduct(Order order, Product product, Integer quantity ){
        this.pk = new OrderProductPK();
        this.pk.setOrder(order);
        this.pk.setProduct(product);
        this.quantity = quantity;
    }

    @Transient
    public Product getProduct(){
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice(){
        return getProduct().getPrice() * this.quantity;
    }

}
