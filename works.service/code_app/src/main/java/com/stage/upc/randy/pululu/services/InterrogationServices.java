package com.stage.upc.randy.pululu.services;

import com.stage.upc.randy.pululu.models.Interrogation;

import java.util.List;

public interface InterrogationServices {
    Interrogation saveInterro(Interrogation i);
    Interrogation updateInterro(Interrogation i);
    void deleteInterro(Interrogation i);
    void deleteInterroById(Long id);
    Interrogation getInterroById(Long id);
    List<Interrogation> getAllInterros();
}
