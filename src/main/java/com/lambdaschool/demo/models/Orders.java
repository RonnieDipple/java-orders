package com.lambdaschool.demo.models;

/* * ORDNUM primary key, not null Long
 * ORDAMOUNT double
 * ADVANCEAMOUNT double
 * CUSTCODE Long foreign key (one customer to many orders) not null
 * ORDERDESCRIPTION String*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //Means it will become a table
@Table(name = "orders")//names the table
public class Orders {

    //every table will have a primary, it identifies the row, make the key length large
    @Id//makes it the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)//Generates the key
    private long ordNum;

    private double ordAmount;
    private double advanceAmount;
    private String orderDescription;

    @ManyToOne
    @JoinColumn(name = "custcode")
    @JsonIgnoreProperties({"agent", "orders"})
    private Customers customer;

    @ManyToMany(mappedBy = "orders")
    private List<Payments> payments = new ArrayList<>();

    public Orders(){

    }

    public Orders(double ordAmount, double advanceAmount, String orderDescription, List<Customers> customers, List<Payments> payments) {
        this.ordAmount = ordAmount;
        this.advanceAmount = advanceAmount;
        this.orderDescription = orderDescription;

    }

    public long getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(long ordNum) {
        this.ordNum = ordNum;
    }

    public double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }


    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }
}
