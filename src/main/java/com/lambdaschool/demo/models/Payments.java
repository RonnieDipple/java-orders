package com.lambdaschool.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payments")
public class Payments
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;

    @Column(nullable = false,
            unique = true)
    private String type;

    @ManyToMany
    @JoinTable(name = "orderspayments", joinColumns = @JoinColumn(name = "paymentid"),
            inverseJoinColumns = @JoinColumn(name = "ordnum"))
    List<Orders> orders = new ArrayList<>();

    public Payments(){

    }

    public Payments(String type, List<Customers> customersList) {
        this.type = type;

    }

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
