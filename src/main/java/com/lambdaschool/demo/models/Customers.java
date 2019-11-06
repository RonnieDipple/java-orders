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
    @OneToMany(mappedBy = "agentCode",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties("agentCode")
    private List<Customers> customers = new ArrayList<>();


    public Customers(){

    }

    //Constructor is long but still just a constructor
    public Customers(String custName, String custCity,
                     String workingArea,
                     String custCountry,
                     String grade,
                     double openingAmt,
                     double receiveAmt,
                     double paymentAmt,
                     double outstandingAmt,
                     String phone,
                     List<Customers> customers) {
        this.custName = custName;
        this.custCity = custCity;
        this.workingArea = workingArea;
        this.custCountry = custCountry;
        this.grade = grade;
        this.openingAmt = openingAmt;
        this.receiveAmt = receiveAmt;
        this.paymentAmt = paymentAmt;
        this.outstandingAmt = outstandingAmt;
        this.phone = phone;
        this.customers = customers;
    }

    public long getCustCode() {
        return custCode;
    }

    public void setCustCode(long custCode) {
        this.custCode = custCode;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt() {
        return openingAmt;
    }

    public void setOpeningAmt(double openingAmt) {
        this.openingAmt = openingAmt;
    }

    public double getReceiveAmt() {
        return receiveAmt;
    }

    public void setReceiveAmt(double receiveAmt) {
        this.receiveAmt = receiveAmt;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public double getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(double outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }
}
