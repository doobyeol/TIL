package com.fastcampus.javaopp.logic;

import java.util.ArrayList;
import java.util.List;

public interface Sort <T extends Comparable<T>>{
    List<T> sort(List<T> list);
}
