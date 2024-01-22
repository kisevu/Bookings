package com.ameda.kevin.cabbooking.service;

import com.ameda.kevin.cabbooking.constants.AppConstants;
import com.ameda.kevin.cabbooking.entity.Driver;
import com.ameda.kevin.cabbooking.payload.DriverPayload;
import com.ameda.kevin.cabbooking.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @Autowired
    private DriverRepository driverRepository;

    public boolean updateLocation(String location){
        kafkaTemplate.send(AppConstants.TOPIC_NAME,location);
        return true;
    }

    public Driver register(DriverPayload payload) throws InterruptedException {
        int maxLocation = 10;
        String result = "";
        while(maxLocation > 0){
           result = Math.random()+" "+Math.random();
           Thread.sleep(1000);
           maxLocation--;
        }

        Driver driver = Driver.builder()
                .name(payload.getName())
                .location(payload.getLocation())
                .coordinates(result)
                .build();
        driverRepository.save(driver);
        kafkaTemplate.send(AppConstants.TOPIC_NAME,driver);
        return driver;
    }
}
