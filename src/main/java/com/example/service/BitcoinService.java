package com.example.service;


import com.example.dto.AvgPriceDto;
import com.example.dto.convertor.AvgPriceConvertor;
import com.example.model.AvgPrice;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitcoinService {

    private final RestTemplate restTemplate;
    private final AvgPriceConvertor avgPriceConvertor;


    public BitcoinService(RestTemplate restTemplate, AvgPriceConvertor avgPriceConvertor) {
        this.restTemplate = restTemplate;
        this.avgPriceConvertor = avgPriceConvertor;
    }


    public AvgPriceDto getAvgPrice(String symbol){
        AvgPrice avgPrice = restTemplate.getForObject("https://api.binance.com/api/v3/avgPrice?symbol="+symbol , AvgPrice.class);
        avgPrice.setSymbol(symbol);
        return avgPriceConvertor.convert(avgPrice);

    }







}
