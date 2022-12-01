package org.top.orderjsonapi.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_t", schema = "orders_db", catalog = "")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_f")
    private Integer idF;
    @Basic
    @Column(name = "name_f")
    private String nameProduct;


    @Basic
    @Column(name = "price_f")
    private Double price;
    @Basic
    @Column(name = "onOffSale_f")
    private String onOffSale;

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public Integer getIdF() {
        return idF;
    }

    public void setIdF(Integer idF) {
        this.idF = idF;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOnOffSale() {
        return onOffSale;
    }

    public void setOnOffSale(String onOffSale) {
        this.onOffSale = onOffSale;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idF=" + idF +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", onOffSale='" + onOffSale + '\'' +
//                ", order=" + order +
                '}';
    }
}
