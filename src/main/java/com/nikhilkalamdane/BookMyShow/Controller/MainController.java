package com.nikhilkalamdane.BookMyShow.Controller;

import com.nikhilkalamdane.BookMyShow.Model.Passanger;
import com.nikhilkalamdane.BookMyShow.Model.Train;
import com.nikhilkalamdane.BookMyShow.Service.impl.TrainService;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.EntryTrainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    TrainService trainService;

    @PostMapping("/addTrain")
    public void addTrain(@RequestBody EntryTrainDto train){
        trainService.addTrain(train);

    }

//    public void addPassanger(@RequestBody Passanger passanger){
//        trainService.addPassanger(passanger);
//    }
}
