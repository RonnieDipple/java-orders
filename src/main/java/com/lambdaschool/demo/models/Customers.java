package com.lambdaschool.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
 * CUSTCODE primary key, not null Long
 * CUSTNAME String, not null
 * CUSTCITY String
 * WORKINGAREA String
 * CUSTCOUNTRY String
 * GRADE String
 * OPENINGAMT double
 * RECEIVEAMT double
 * PAYMENTAMT double
 * OUTSTANDINGAMT double
 * PHONE String
 * AGENTCODE Long foreign key (one agent to many customers) not null

 */

@Entity //Means it will become a table
@Table(name = "customers")//names the table
public class Customers {

    //every table will have a primary, it identifies the row, make the key length large
    @Id//makes it the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)//Generates the key
    private long custCode;
    private String custName;
    private String custCity;
    private String workingArea;
    private String custCountry;
    private String grade;
    private double openingAmt;
    private double receiveAmt;
    private double paymentAmt;
    private double outstandingAmt;
    private String phone;

    // AGENTCODE Long foreign key (one agent to many customers) not null
    @OneToMany(mappedBy = "agent",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties("agent")
    private List<Customers> customers = new ArrayList<>();

}
