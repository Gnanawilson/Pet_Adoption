package com.examly.springapp.controller;

import com.examly.springapp.model.AdoptionRequest;
import com.examly.springapp.service.AdoptionRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adoption-requests")
public class AdoptionRequestController 
{

  @Autowired
  private AdoptionRequestService adoptionRequestService;

  @PostMapping
  public ResponseEntity<?> createAdoptionRequest(@Valid @RequestBody AdoptionRequest request) 
  {
    try {
      AdoptionRequest saved = adoptionRequestService.createAdoptionRequest(request);
      return ResponseEntity.status(201).body(saved);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(java.util.Map.of("message", e.getMessage()));
    }
  }

  @GetMapping
  public ResponseEntity<List<AdoptionRequest>> getAllAdoptionRequests() {
    return ResponseEntity.ok(adoptionRequestService.getAllAdoptionRequests());
  }
}

