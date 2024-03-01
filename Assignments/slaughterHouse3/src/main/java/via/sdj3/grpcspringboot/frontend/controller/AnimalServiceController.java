package via.sdj3.grpcspringboot.frontend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sdj3.grpcspringboot.frontend.entity.Animal;
import via.sdj3.grpcspringboot.frontend.service.AnimalService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AnimalServiceController {
	private AnimalService animalService;

	public AnimalServiceController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping(value="/animals/{Id}")
	public ResponseEntity<Object> getAnimalById(@PathVariable ("id") int id){
		Optional<Animal> animal = animalService.getAnimalById(id);
		if (!animal.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(animal.get(), HttpStatus.OK);
	}

	@GetMapping("/animals")
	public ResponseEntity<List<Animal>> getAllAnimals(){
		List<Animal> animals = animalService.getAllAnimals();
		return new ResponseEntity<>(animals, HttpStatus.OK);
	}

	@PostMapping(value="/animals")
	public ResponseEntity<Object> addAnimal(@RequestBody Animal animal){
		animalService.addAnimal(animal);
		return new ResponseEntity<>("Animal successfully added", HttpStatus.CREATED);
	}

	@GetMapping(value="/animals2/{date}")
	public ResponseEntity<List<Animal>> getAllAnimalsByArrivalDate(@PathVariable Date date){
		List<Animal> animals = animalService.getAllAnimalsByArrivalDate(date);
		return new ResponseEntity<>(animals, HttpStatus.OK);
	}

	@GetMapping("/animals/origin")
	public ResponseEntity<List<Animal>> getAllAnimalsByOrigin(@PathVariable String origin){
		List<Animal> animals = animalService.getAllAnimalsByOrigin(origin);
		return new ResponseEntity<>(animals, HttpStatus.OK);
	}
}
