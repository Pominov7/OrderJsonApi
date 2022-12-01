package org.top.orderjsonapi.db.entity;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "order_t", schema = "orders_db", catalog = "")
public class Order {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_f")
    private Integer idF;
    @Basic
    @Column(name = "name_f")
    private String nameClient;
    @Basic
    @Column(nullable = false, length = 200)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Integer getIdF() {
        return idF;
    }

    public void setIdF(Integer idF) {
        this.idF = idF;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idF=" + idF +
                ", nameClient='" + nameClient + '\'' +
                ", date=" + date +
                '}';
    }
}
