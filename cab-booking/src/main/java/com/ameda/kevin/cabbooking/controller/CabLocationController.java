package com.ameda.kevin.cabbooking.controller;

import com.ameda.kevin.cabbooking.payload.DriverPayload;
import com.ameda.kevin.cabbooking.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cab/location")
public class CabLocationController {
    @Autowired
    private CabLocationService cabLocationService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody DriverPayload payload) throws InterruptedException {
        return ResponseEntity.ok(cabLocationService.register(payload));
    }

//    @PutMapping
//    public ResponseEntity<?> updatedLocation() throws InterruptedException {
//        int max=50;
//        while(max>0){
//            cabLocationService.updateLocation(Math.random()+","+Math.random());
//            Thread.sleep(1000);
//            max--;
//        }
//        return new ResponseEntity<>(
//                Map.of("message","Location successfully updated...")
//                ,HttpStatus.OK);
//    }
}
