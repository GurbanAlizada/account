package com.example.controller;


import com.example.dto.AvgPriceDto;
import com.example.service.BitcoinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bitcoin")
public class BitcoinController {

    private final BitcoinService bitcoinService;


    public BitcoinController(BitcoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }

    @GetMapping("/avgPrice/{symbol}")
    public ResponseEntity<AvgPriceDto> getAvgPrice(@PathVariable String symbol){
        return ResponseEntity.ok(bitcoinService.getAvgPrice(symbol));
    }






}
