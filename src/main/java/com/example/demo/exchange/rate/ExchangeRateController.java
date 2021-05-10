package com.example.demo.exchange.rate;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Optional;

//@RestController
@Controller
public class ExchangeRateController {
    @Autowired
    private RestTemplate restTemplate;


    /**
     * example
     * http://localhost:8080/exchange/rate/latest?currency=USD
     * http://localhost:8080/exchange/rate/latest default EUR
     *
     * @param currency
     * @return
     */
    //    @RequestMapping("latest-foreign-exchange")
    @RequestMapping(value = "exchange/rate/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object exchangeRateLatestWithQueryParam(@RequestParam Optional<String> currency) {

        String LATEST_EXCHANGE_URL = "https://api.exchangeratesapi.io/latest";


        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(LATEST_EXCHANGE_URL)
//                .queryParam("base", (currency == null) ? null : currency.toUpperCase());
                .queryParam("base", currency.map(c -> c.toUpperCase()).orElse(null));

        Object object = restTemplate.getForObject(builder.toUriString(), Object.class);
        return object;
    }

    /**
     * example
     * http://localhost:8080/exchange/rate/USD/latest
     *
     * @param currency
     * @return
     */
    @RequestMapping(value = "exchange/rate/{currency}/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object exchangeRateLatestWithPathVariable(@PathVariable("currency") String currency) {

        String LATEST_EXCHANGE_URL = "https://api.exchangeratesapi.io/latest";

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(LATEST_EXCHANGE_URL)
                .queryParam("base", currency.toUpperCase());

        Object object = restTemplate.getForObject(builder.toUriString(), Object.class);
        return object;
    }

    @RequestMapping(value = "exchange", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object exchange() {

        return "USD, EUR, CHF, AUD";
    }

    @RequestMapping(value = "exchange/rate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object exchangeRate() {

        return "From 0 to 300000";
    }

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("message", "Ehsan");
        model.addAttribute("tasks", Arrays.asList("A", "B"));

        return "welcome";
    }

    //    http://localhost:8080/exchange/rate/usd/to/EUR
    @RequestMapping(value = "exchange/rate/{first-currency}/to/{second-currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public double exchangeRate(@PathVariable("first-currency") String firstCurrency, @PathVariable("second-currency") String secondCurrency) throws JsonProcessingException {

        if (firstCurrency.toUpperCase().equals(secondCurrency.toUpperCase())) return 1.0;
//        List<String> ratenames = RateModel.getRateName;
//        boolean isExisted = ratenames.stream().findFirst();
//        if(!isExisted) return 0.0;


        String LATEST_EXCHANGE_URL = "https://api.exchangeratesapi.io/latest";
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(LATEST_EXCHANGE_URL)
                .queryParam("base", firstCurrency.toUpperCase());

        ExchangeResultModel result = restTemplate.getForObject(builder.toUriString(), ExchangeResultModel.class);

        RatesModel rates = result.getRates();

//        double exchangeRate = rates.getAllRates().getOrDefault(secondCurrency.toUpperCase(), 0d);
        double exchangeRate = rates.getAllRatesV2().getOrDefault(secondCurrency.toUpperCase(), 0d);


        return exchangeRate;
    }


//    //    http://localhost:8080/exchange/rate/usd/to/EUR
//    @RequestMapping(value = "exchange/rate/{first-currency}/to/{second-currency}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public double exchangeRate(@PathVariable("first-currency") String firstCurrency, @PathVariable("second-currency") String secondCurrency) throws JsonProcessingException {
//
//        String LATEST_EXCHANGE_URL = "https://api.exchangeratesapi.io/latest";
//
//        UriComponentsBuilder builder = UriComponentsBuilder
//                .fromUriString(LATEST_EXCHANGE_URL)
//                .queryParam("base", firstCurrency.toUpperCase());
//
//        ExchangeResultModel result = restTemplate.getForObject(builder.toUriString(), ExchangeResultModel.class);
////
////        ObjectMapper mapper = new ObjectMapper();
////        ExchangeResultModel finalResult = mapper.readValue(result.toString(), ExchangeResultModel.class);
//
//        RatesModel rates = result.getRates();
//
//        double exchangeRate = 0d;
//
////        switch (secondCurrency) {
////            case "AUD":
////                exchangeRate = rates.getAUD();
////                break;
////            case "EUR":
////                exchangeRate = result.getRates().getEUR();
////                break;
////
////        }
//
//        exchangeRate = rates.getAllRates().get(secondCurrency.toUpperCase());
//
//
//        return exchangeRate;
//    }
}