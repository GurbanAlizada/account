package com.example.model;


import lombok.Data;
import java.math.BigDecimal;

@Data
public class AvgPrice {

    private int mins;
    private BigDecimal price;
    private String symbol;


}
