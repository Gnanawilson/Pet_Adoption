package com.examly.springapp.service;

import com.examly.springapp.model.AdoptionRequest;
import com.examly.springapp.model.Pet;
import com.examly.springapp.repository.AdoptionRequestRepository;
import com.examly.springapp.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdoptionRequestService {

@Autowired
private AdoptionRequestRepository adoptionRequestRepository;

@Autowired
private PetRepository petRepository;

public AdoptionRequest createAdoptionRequest(AdoptionRequest request) {
Pet pet = petRepository.findById(request.getPetId())
.orElseThrow(() -> new IllegalArgumentException("Pet is not available for adoption"));

if (!"Available".equalsIgnoreCase(pet.getAdoptionStatus())) {
throw new IllegalArgumentException("Pet is not available for adoption");
}

request.setStatus("Pending");
request.setSubmissionDate(LocalDateTime.now());
return adoptionRequestRepository.save(request);
}

public List<AdoptionRequest> getAllAdoptionRequests() {
return adoptionRequestRepository.findAll();
}
}

