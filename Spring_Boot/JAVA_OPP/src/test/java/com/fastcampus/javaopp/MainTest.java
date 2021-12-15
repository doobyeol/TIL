package com.fastcampus.javaopp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main(){
        //Given
        String[] args = {"3", "1", "2"};

        // When and Then
        Main.main(args);
    }
}