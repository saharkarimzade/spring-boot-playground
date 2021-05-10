package com.example.demo.exchange.rate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClassStream2 {

    public static void main(String[] args) {


        List<String> list1 = new ArrayList<>();
        list1.add("ehsan");
        list1.add("sahar");
        List<String> list2 = Arrays.asList("sahar", "ehsan", "hormoz");

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("--------------1---------------");


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        String[] array1 = new String[]{"nalbeki", "haji"};
        System.out.print("array1 = ");
        for (int i = 0; i < array1.length; i++) {

            System.out.print(array1[i] + ", ");
        }
        System.out.println("");
        System.out.println("--------------2---------------");

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        Stream<String> bbbb = list1.stream();
        System.out.println("bbbb = " + bbbb);
        System.out.println("bbbb with collect = " + bbbb.collect(Collectors.toList()));
        System.out.println("--------------3---------------");

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Optional<String> optList1 = list1.stream().findFirst();
        System.out.println("optList1 = " + optList1);
        Optional<String> optList2 = list2.stream().findFirst();
        System.out.println("optList2 = " + optList2);

        List<String> emptyList = new ArrayList<>();
        Optional<String> emptyOptional = emptyList.stream().findFirst();
        System.out.println("emptyOptional = " + emptyOptional);

        System.out.println("--------------4---------------");


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        Stream<String> aaa = Arrays.stream(array1);
        System.out.println("aaa = " + aaa);

        Optional<String> optFirst = Arrays.stream(array1).findFirst();
        System.out.println("optFirst = " + optFirst);

        List<String> array1ToList = Arrays.asList(array1);
        System.out.println("array1ToList = " + array1ToList);

        Stream<String> ccc = array1ToList.stream();
        System.out.println("ccc = " + ccc);


    }
}
