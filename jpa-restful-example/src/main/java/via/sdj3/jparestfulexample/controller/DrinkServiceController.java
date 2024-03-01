package via.sdj3.jparestfulexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sdj3.jparestfulexample.entity.Drink;
import via.sdj3.jparestfulexample.service.DrinkService;

import java.util.List;
import java.util.Optional;

@RestController
public class DrinkServiceController {
	private DrinkService drinkService;

	public DrinkServiceController(DrinkService drinkService) {
		this.drinkService = drinkService;
	}

	@GetMapping("/drinks/{Id}")
	public ResponseEntity<Object> getDrinkById(@PathVariable ("id") int id){
		Optional<Drink> drink = drinkService.getDrinkById(id);
		if (!drink.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(drink.get(), HttpStatus.OK);
	}

	@GetMapping("/drinks")
	public ResponseEntity<List<Drink>> getAllDrinks(){
		List<Drink> drinks = drinkService.getALlDrinks();
		return new ResponseEntity<>(drinks, HttpStatus.OK);
	}

	@PostMapping(value="/drinks")
	public ResponseEntity<Object> addDrink(@RequestBody Drink drink){
		drinkService.addDrink(drink);
		return new ResponseEntity<>("Drink successfully added", HttpStatus.CREATED);
	}
}
