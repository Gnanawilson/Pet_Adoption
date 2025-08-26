package com.examly.springapp.service;

import com.examly.springapp.model.Pet;
import com.examly.springapp.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

@Autowired
private PetRepository petRepository;

public Pet createPet(Pet pet) {
return petRepository.save(pet);
}

public List<Pet> getAllPets() {
return petRepository.findAll();
}

public Optional<Pet> getPetById(Long id) {
return petRepository.findById(id);
}

public List<Pet> getPetsBySpecies(String species) {
throw new UnsupportedOperationException("Unimplemented method 'getPetsBySpecies'");
}
}

