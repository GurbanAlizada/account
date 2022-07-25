package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transaction_type")
    private TransactionType transactionType = TransactionType.INITIAL;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "account_id" , nullable = false)
    private Account account;

    public Transaction(String id, BigDecimal amount, LocalDateTime transactionDate, Account account) {
        this.id = id;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account = account;
    }

    public Transaction(BigDecimal amount, Account account) {
        this.amount = amount;
        this.account = account;
    }
}
