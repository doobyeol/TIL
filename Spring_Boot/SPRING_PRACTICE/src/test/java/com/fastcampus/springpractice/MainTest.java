package com.fastcampus.springpractice;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

@Component
class MainTest {

    @Test
    void main(){
        //Given
        String[] args = {"3", "1", "2"};

        // When and Then
        Main.main(args);
    }
}