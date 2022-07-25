package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "creatition_date")
    private LocalDateTime creatitionTime;


    // Bir Accountun bir Customer-i var ama bir customer-in n account-u var
    @ManyToOne(fetch = FetchType.LAZY  , cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer;



    // Bir Accountda n Tracsaction var Bir Transactionda bir Account ola biler
    @OneToMany(mappedBy = "account" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>() ;

    public Account(String id, BigDecimal balance, LocalDateTime creatitionTime, Customer customer) {
        this.id = id;
        this.balance = balance;
        this.creatitionTime = creatitionTime;
        this.customer = customer;
    }
}
