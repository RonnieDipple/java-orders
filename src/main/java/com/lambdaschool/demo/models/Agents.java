package com.lambdaschool.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/* AGENTS
 * AGENTCODE primary key, not null Long
 * AGENTNAME string
 * WORKINGAREA string
 * COMMISSION double
 * PHONE string
 * COUNTRY string*/

@Entity //Means it will become a table
@Table(name = "agents")//names the table
public class Agents {

    //every table will have a primary, it identifies the row, make the key length large
    @Id//makes it the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)//Generates the key
    private long agentCode;

    private String agentName;
    private String workingArea;
    private double commission;
    private String phone;
    private String country;

    public Agents(String agentName, String workingArea, double commission, String phone, String country) {
        this.agentName = agentName;
        this.workingArea = workingArea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("agent")
    private List<Customers> customers = new ArrayList<>();

    public Agents(){
        //silly default constructor that you must use, why oh why java
    }

    public long getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(long agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
