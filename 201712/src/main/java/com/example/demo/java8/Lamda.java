package com.example.demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by chunmei on 1/5/2018.
 */

public class Lamda {
    public void example()
    {
        List<Integer> array = Arrays.asList(1, 2, 3, 4);
        array.forEach(n -> System.out.println(n));
        array.forEach(System.out::println);
        Collections.sort(array, Integer::compareTo);
    }


}
