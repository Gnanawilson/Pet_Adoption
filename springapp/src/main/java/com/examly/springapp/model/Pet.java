package com.examly.springapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Pet {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Pet name is required")
  private String name;

  @NotBlank(message = "Species is required")
  private String species;

  @NotBlank(message = "Breed is required")
  private String breed;

  @Min(value = 0, message = "Age must be non-negative")
  private int age;

  private String description;

  private String imageUrl;

  @Pattern(regexp = "Available|Pending|Adopted", message = "Adoption status must be Available, Pending, or Adopted")
  private String adoptionStatus;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getAdoptionStatus() {
    return adoptionStatus;
  }

  public void setAdoptionStatus(String adoptionStatus) {
    this.adoptionStatus = adoptionStatus;
  }

  public Pet() {
  }

}

