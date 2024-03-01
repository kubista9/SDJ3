package via.sdj3.jparestfulexample.service;

import org.springframework.stereotype.Service;
import via.sdj3.jparestfulexample.entity.Drink;
import via.sdj3.jparestfulexample.repository.DrinkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {
	private DrinkRepository drinkRepository;
	public DrinkService(DrinkRepository drinkRepository) {
		this.drinkRepository = drinkRepository;
	}
	public Optional<Drink> getDrinkById(int id){
		return drinkRepository.findById(id);
	}

	public List<Drink> getALlDrinks(){
		List<Drink> drinks = new ArrayList<>();
		drinkRepository.findAll().forEach(drink -> drinks.add(drink));
		return drinks;
	}

	public void addDrink(Drink drink){
		drinkRepository.save(drink);
	}
}
