package com.example.spring.demo.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class DevDtoTest {
    @Test
    void test(){
        //DevDto devDto = new DevDto("sonw", 21);
        final DevDto devDto = DevDto.builder()
                .name("sonw")
                .age(22)
                .startAt(LocalDateTime.now())
                .experienceYears(3)
                .build();

        //devDto.setName("snow");
        //devDto.setAge(21);

        // any works

        /*if(devDto.getName().equals("summer")){
            devDto.setAge(44);
        }*/

        //devDto.setStartAt(LocalDateTime.now());
        //System.out.println(devDto.getName());
        System.out.println(devDto);
        devDto.printLog();
    }
}