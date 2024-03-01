package via.sdj3.grpcspringboot.frontend.service;

import via.sdj3.grpcspringboot.frontend.entity.Animal;
import org.springframework.stereotype.Service;
import via.sdj3.grpcspringboot.frontend.repository.AnimalRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
	private AnimalRepository animalRepository;

	public AnimalService(AnimalRepository animalRepository){
		this.animalRepository = animalRepository;
	}

	public Optional<Animal> getAnimalById(int id){
		return animalRepository.findById(id);
	}

	public List<Animal> getAllAnimals(){
		List<Animal> animals = new ArrayList<>();
		animalRepository.findAll().forEach(animal -> animals.add(animal));
		return animals;
	}

	public void addAnimal(Animal animal){
		animalRepository.save(animal);
	}

	public List<Animal> getAllAnimalsByArrivalDate(Date date){
		List<Animal> animals = new ArrayList<>();
		animalRepository.findAll().forEach(animal -> {
			if (animal.getArrivalDate().equals(date)){
				animals.add(animal);
			}
		});
		return animals;
	}

	public List<Animal> getAllAnimalsByOrigin(String origin){
		List<Animal> animals = new ArrayList<>();
		animalRepository.findAll().forEach(animal -> {
			if (animal.getFarm().equals(origin)){
				animals.add(animal);
			}
		});
		return animals;
	}
}
