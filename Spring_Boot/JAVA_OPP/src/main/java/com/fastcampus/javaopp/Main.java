package com.fastcampus.javaopp;

import com.fastcampus.javaopp.logic.BubbleSort;
import com.fastcampus.javaopp.logic.JavaSort;
import com.fastcampus.javaopp.logic.Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //BubbleSort<String> sort = new BubbleSort<>();
        Sort<String> sort = new JavaSort<>();
        System.out.println("(result)" + sort.sort(Arrays.asList(args)));
    }
}
