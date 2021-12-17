package com.fastcampus.javaopp.service;

import com.fastcampus.javaopp.logic.JavaSort;
import com.fastcampus.javaopp.logic.Sort;

import java.util.List;

public class SortService {

    private final Sort<String> sort;

    public SortService(Sort<String> sort) {
        this.sort = sort;
        System.out.println("[구현체] : " + sort.getClass().getName());
    }

    public List<String> doSort(List<String> list) {
        return sort.sort(list);
    }
}
