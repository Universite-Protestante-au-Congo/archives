package com.stage.upc.randy.pululu.services.implementation;

import com.stage.upc.randy.pululu.models.Interrogation;
import com.stage.upc.randy.pululu.repository.InterrogationRepository;
import com.stage.upc.randy.pululu.services.InterrogationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterrogationServicesImp implements InterrogationServices {
    @Autowired
    InterrogationRepository interrogationRepository;
    @Override
    public Interrogation saveInterro(Interrogation i) {
        return interrogationRepository.save(i);
    }

    @Override
    public Interrogation updateInterro(Interrogation i) {
        return interrogationRepository.save(i);
    }

    @Override
    public void deleteInterro(Interrogation i) {
        interrogationRepository.delete(i);
    }

    @Override
    public void deleteInterroById(Long id) {
        interrogationRepository.deleteById(id);
    }

    @Override
    public Interrogation getInterroById(Long id) {
        return interrogationRepository.findById(id).get();
    }

    @Override
    public List<Interrogation> getAllInterros() {
        return interrogationRepository.findAll();
    }
}
