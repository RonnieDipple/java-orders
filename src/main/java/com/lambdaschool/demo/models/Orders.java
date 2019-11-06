package com.lambdaschool.demo.models;

/* * ORDNUM primary key, not null Long
 * ORDAMOUNT double
 * ADVANCEAMOUNT double
 * CUSTCODE Long foreign key (one customer to many orders) not null
 * ORDERDESCRIPTION String*/

import javax.persistence.*;

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

    private long custCode;


}
