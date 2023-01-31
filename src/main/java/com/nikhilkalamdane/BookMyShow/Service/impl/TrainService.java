package com.nikhilkalamdane.BookMyShow.Service.impl;


import com.nikhilkalamdane.BookMyShow.Model.Passanger;
import com.nikhilkalamdane.BookMyShow.Model.Train;
import com.nikhilkalamdane.BookMyShow.Repository.TrainRepository;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.EntryTrainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public void addTrain(EntryTrainDto t){
        Train train = Train.builder()
                .source(t.getSource())
                .destination(t.getDestination())
                .build();
        trainRepository.save(train);
    }

//    public void addPassanger(Passanger passanger) {
//        trainRepository.save(passanger);
//    }
}
