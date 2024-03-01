package via.sdj3.slaughterhousepart2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sdj3.slaughterhousepart2.entity.Animal;
import via.sdj3.slaughterhousepart2.service.AnimalService;
import via.sdj3.slaughterhousepart2.service.AnimalServiceInterface;

@RestController
public class AnimalServiceController{
  private AnimalServiceInterface animalService;

  public AnimalServiceController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @PostMapping(value="/animals/test")
  public ResponseEntity<Object> addAnimal(@RequestBody Animal animal){
    try {
      animalService.addAnimal(animal);
      System.out.println("Returning entity...");
      return ResponseEntity.ok().body(animal);
    }
    catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

  }
}
