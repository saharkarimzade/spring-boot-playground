package com.example.demo.exchange.rate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestClassStream {

    public static void main(String[] args) {


        List<Integer> numberOfDays = new ArrayList<>();

        numberOfDays.add(1);
        numberOfDays.add(2);
        numberOfDays.add(3);
        numberOfDays.add(4);
        numberOfDays.add(5);
        numberOfDays.add(6);
        numberOfDays.add(7);
        numberOfDays.add(2);

        System.out.println("numberOfDays = " + numberOfDays);


        List<String> weeksDays =
                numberOfDays
                        .stream()
                        .map(daysNumber ->
                        {

                            System.out.println("print in map daysNumber = " + daysNumber);
                            String dayName = "";

                            if (daysNumber == 1) dayName = "Sat";
                            else if (daysNumber == 2) dayName = "Sun";
                            else if (daysNumber == 3) dayName = "Mon";
                            else if (daysNumber == 4) dayName = "Tue";
                            else if (daysNumber == 5) dayName = "Wed";
                            else if (daysNumber == 6) dayName = "Thr";
                            else if (daysNumber == 7) dayName = "Fri";

                            return dayName;
                        }).collect(Collectors.toList());

        System.out.println("weekDays = " + weeksDays);


    }
}
