package com.example.demo.exchange.rate;

import lombok.Data;


@Data
public class ExchangeResultModel {
    private RatesModel rates;
    private String base;
    private String date;
}
