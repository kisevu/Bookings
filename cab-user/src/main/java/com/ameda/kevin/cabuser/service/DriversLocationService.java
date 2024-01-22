package com.ameda.kevin.cabuser.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DriversLocationService {

    @KafkaListener(topics = "cab-topic", groupId = "user-group")
    public void driversLocationGet(String location){
        System.out.println(location);
    }
}
