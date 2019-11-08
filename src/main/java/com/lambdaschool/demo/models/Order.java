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
public class Order {

    //every table will have a primary, it identifies the row, make the key length large
    @Id//makes it the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)//Generates the key
    private long ordnum;
    private double ordamount;
    private double advanceamount;
    private String orderdescription;

    @ManyToOne
    @JoinColumn(name = "custcode")
    @JsonIgnoreProperties({"agent", "orders"})
    private Customer customer;

    @ManyToMany(mappedBy = "orders")
    private List<Payment> payments = new ArrayList<>();

    public Order(){

    }

    public Order(double ordamount, double advanceamount, Customer customer, String orderdescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.customer = customer;
        this.orderdescription = orderdescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
