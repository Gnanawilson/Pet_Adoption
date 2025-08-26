package com.examly.springapp.controller;

import com.examly.springapp.model.Pet;
import com.examly.springapp.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

  @Autowired
  private PetService petService;

  @GetMapping
  public ResponseEntity<List<Pet>> getAllPets() {
    return ResponseEntity.ok(petService.getAllPets());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getPetById(@PathVariable Long id) 
  {
    Optional<Pet> optionalPet = petService.getPetById(id);
    if (optionalPet.isPresent()) {
      return ResponseEntity.ok(optionalPet.get());
    } else {
      return ResponseEntity.status(404).body(new ErrorResponse("Pet with ID " + id + " not found"));
    }
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@Valid @RequestBody Pet pet) 
    {
      Pet savedPet = petService.createPet(pet);
      return ResponseEntity.status(201).body(savedPet);
    }

    static class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
    this.message = message;
    }

    public String getMessage() {
    return message;
    }
  }
}

