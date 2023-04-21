package com.example.dto.convertor;


import com.example.dto.AvgPriceDto;
import com.example.model.AvgPrice;
import org.springframework.stereotype.Component;

@Component
public class AvgPriceConvertor {

    public AvgPriceDto convert(AvgPrice from){
        return new AvgPriceDto(from.getMins() ,from.getPrice(), from.getSymbol() );
    }

}
