package com.ameda.kevin.cabuser.controller;

import com.ameda.kevin.cabuser.service.DriversLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/driver/locations")
public class DriversLocationController {

    @Autowired
    private DriversLocationService driversLocationService;
    @GetMapping
    public ResponseEntity<?> getDriversLocation(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
