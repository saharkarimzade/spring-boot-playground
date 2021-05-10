package com.example.demo.exchange.rate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonAutoDetect
@Data
public class RatesModel {

    // Note: Using reflection do not use fields with the length of 3
    private Map<String, Double> allRates;
    private Map<String, Double> allRatesV2;

    @JsonProperty
    private double CAD;
    @JsonProperty
    private double HKD;
    @JsonProperty
    private double ISK;
    @JsonProperty
    private double PHP;
    @JsonProperty
    private double DKK;
    @JsonProperty
    private double HUF;
    @JsonProperty
    private double CZK;
    @JsonProperty
    private double AUD;
    @JsonProperty
    private double RON;
    @JsonProperty
    private double SEK;
    @JsonProperty
    private double IDR;
    @JsonProperty
    private double INR;
    @JsonProperty
    private double BRL;
    @JsonProperty
    private double RUB;
    @JsonProperty
    private double HRK;
    @JsonProperty
    private double JPY;
    @JsonProperty
    private double THB;
    @JsonProperty
    private double CHF;
    @JsonProperty
    private double SGD;
    @JsonProperty
    private double PLN;
    @JsonProperty
    private double BGN;
    @JsonProperty
    private double TRY;
    @JsonProperty
    private double CNY;
    @JsonProperty
    private double NOK;
    @JsonProperty
    private double NZD;
    @JsonProperty
    private double ZAR;
    @JsonProperty
    private double USD;
    @JsonProperty
    private double MXN;
    @JsonProperty
    private double ILS;
    @JsonProperty
    private double GBP;
    @JsonProperty
    private double KRW;
    @JsonProperty
    private double MYR;
    @JsonProperty
    private double EUR;

    @Deprecated
    public Map<String, Double> getAllRates() {

        //For performance (not calculating again)
        if (allRates != null) return allRates;

        allRates = new HashMap<>();
        allRates.put("AUD", getAUD());
        allRates.put("BGN", getBGN());
        allRates.put("BRL", getBRL());
        allRates.put("CAD", getCAD());
        allRates.put("CHF", getCHF());
        allRates.put("CNY", getCNY());
        allRates.put("CZK", getCZK());
        allRates.put("DKK", getDKK());
        allRates.put("EUR", getEUR());
        allRates.put("GBP", getGBP());
        allRates.put("HKD", getHKD());
        allRates.put("HRK", getHRK());
        allRates.put("HUF", getHUF());
        allRates.put("IDR", getIDR());
        allRates.put("ILS", getILS());
        allRates.put("INR", getINR());
        allRates.put("ISK", getISK());
        allRates.put("JPY", getJPY());
        allRates.put("KRW", getKRW());
        allRates.put("MXN", getMXN());
        allRates.put("MYR", getMYR());
        allRates.put("NOK", getNOK());
        allRates.put("NZD", getNZD());
        allRates.put("PHP", getPHP());
        allRates.put("PLN", getPLN());
        allRates.put("RON", getRON());
        allRates.put("RUB", getRUB());
        allRates.put("SEK", getSEK());
        allRates.put("SGD", getSGD());
        allRates.put("THB", getTHB());
        allRates.put("TRY", getTRY());
        allRates.put("USD", getUSD());
        allRates.put("ZAR", getZAR());
        return allRates;
    }


    public Map<String, Double> getAllRatesV2() {

        //For performance (not calculating again)
//        if (allRatesV2 != null) return allRatesV2;

        List<Map<String, Double>> fieldsValues =
                Arrays.stream(this.getClass().getDeclaredFields())
                        .filter(f -> f.getName().length() == 3)
                        .map(f -> {

                            String fieldName = f.getName();
                            double fieldValue = 0d;
                            try {
                                fieldValue = Double.parseDouble(f.get(this).toString());

                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                            Map<String, Double> mapWithOneEntry = new HashMap<>();
                            mapWithOneEntry.put(fieldName, fieldValue);

                            return mapWithOneEntry;
                        }).collect(Collectors.toList());

        Map<String, Double> finalResult = fieldsValues.stream().collect(Collectors.toMap(mapWithOneEntry -> {
            String name = mapWithOneEntry.entrySet().stream().findFirst().get().getKey();

            return name;
        }, mapWithOneEntry -> {
            return mapWithOneEntry.entrySet().stream().findFirst().get().getValue();
        }));
        allRatesV2 = finalResult; // For performance
        return finalResult;
    }

//
//    public List<String> getRateNames() {
//        List<String> fieldNames = new ArrayList();
//
//        fieldNames.add(this.getClass().getDeclaredFields().toString());
//return  fieldNames
//    }

    public List<String> getRateNames() {

        List<String> allRateNames = new ArrayList<>();


        allRateNames.add("AUD");
        allRateNames.add("BGN");
        allRateNames.add("BRL");
        allRateNames.add("CAD");
        allRateNames.add("CHF");
        allRateNames.add("CNY");
        allRateNames.add("CZK");
        allRateNames.add("DKK");
        allRateNames.add("EUR");
        allRateNames.add("GBP");
        allRateNames.add("HKD");
        allRateNames.add("HRK");
        allRateNames.add("HUF");
        allRateNames.add("IDR");
        allRateNames.add("ILS");
        allRateNames.add("INR");
        allRateNames.add("ISK");
        allRateNames.add("JPY");
        allRateNames.add("KRW");
        allRateNames.add("MXN");
        allRateNames.add("MYR");
        allRateNames.add("NOK");
        allRateNames.add("NZD");
        allRateNames.add("PHP");
        allRateNames.add("PLN");
        allRateNames.add("RON");
        allRateNames.add("RUB");
        allRateNames.add("SEK");
        allRateNames.add("SGD");
        allRateNames.add("THB");
        allRateNames.add("TRY");
        allRateNames.add("USD");
        allRateNames.add("ZAR");

        return allRateNames;
    }


    public List<String> checkRateName(String r) {

//getAllRatesV2().get(r);

//        List<String> a = new ArrayList<>();
        List<String> fieldsValues =
                Arrays.stream(this.getClass().getDeclaredFields())
                        .filter(f -> f.getName().length() == 3)
                        .map(f -> f.getName()).collect(Collectors.toList());
//        List<String> sahar = new ArrayList<>();

//        Arrays.stream(this.getClass().getDeclaredFields())
//        this.getClass().getDeclaredFields().stream()
//
//        sahar.stream().findFirst();
//        return fieldsValues.stream().map();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = Arrays.asList();

        String[] array1 = new String[]{};

        Stream<String> bbbb = list1.stream();

        list1.stream().findFirst();
        list2.stream().findFirst();

        Stream<String> aaa = Arrays.stream(array1);
        Arrays.stream(array1).findFirst();

        List<String> array1ToList = Arrays.asList(array1);
        array1ToList.stream();

        return null;

    }


}
