package com.stage.upc.randy.pululu.services.implementation;

import com.stage.upc.randy.pululu.models.PraticalWork;
import com.stage.upc.randy.pululu.repository.PraticalWorkRepository;
import com.stage.upc.randy.pululu.services.PraticalWorkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PraticalWorkServicesImp implements PraticalWorkServices {
    @Autowired
    PraticalWorkRepository praticalWorkRepository;
    @Override
    public PraticalWork savePraticalWork(PraticalWork p) {
        return praticalWorkRepository.save(p);
    }

    @Override
    public PraticalWork updatePraticalWork(PraticalWork p) {
        return praticalWorkRepository.save(p);
    }

    @Override
    public void deletePraticalWork(PraticalWork p) {
        praticalWorkRepository.delete(p);
    }

    @Override
    public void delelePraticalWorkById(Long id) {
        praticalWorkRepository.deleteById(id);
    }

    @Override
    public PraticalWork getPraticalWorkByid(Long id) {
        return praticalWorkRepository.findById(id).get();
    }

    @Override
    public List<PraticalWork> getAllPraticalWorks() {
        return praticalWorkRepository.findAll();
    }
}
