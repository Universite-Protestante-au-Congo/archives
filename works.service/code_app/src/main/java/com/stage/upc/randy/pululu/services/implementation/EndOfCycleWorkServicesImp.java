package com.stage.upc.randy.pululu.services.implementation;

import com.stage.upc.randy.pululu.models.EndOfCycleWork;
import com.stage.upc.randy.pululu.models.Work;
import com.stage.upc.randy.pululu.repository.EndOfCycleWorkRepository;
import com.stage.upc.randy.pululu.services.EndOfCycleWorkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EndOfCycleWorkServicesImp implements EndOfCycleWorkServices {
    @Autowired
    EndOfCycleWorkRepository workRepository;
    @Override
    public EndOfCycleWork saveWork(EndOfCycleWork a) {
        return workRepository.save(a);
    }

    @Override
    public EndOfCycleWork updateWork(EndOfCycleWork a) {
        return workRepository.save(a);
    }

    @Override
    public void deleteWork(EndOfCycleWork a) {
        workRepository.delete(a);
    }

    @Override
    public void deleteWorkById(Long id) {
        workRepository.deleteById(id);
    }

    @Override
    public Work getWork(Long id) {
        return workRepository.findById(id).get();
    }

    @Override
    public List<EndOfCycleWork> getAllWorks() {
        return workRepository.findAll();
    }
}
