package via.sdj3.slaughterhousepart2.service;

import org.springframework.stereotype.Service;
import via.sdj3.slaughterhousepart2.entity.Animal;
import via.sdj3.slaughterhousepart2.repository.IAnimalRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService
{
  private IAnimalRepository animalRepository;

  public AnimalService(IAnimalRepository animalRepository){
    this.animalRepository=animalRepository;
  }

  public Optional<Animal> getAnimalByRegistrationNo(int registrationNo){
    return animalRepository.findById(registrationNo);
  }

  public List<Animal> getAllAnimals(){
    List<Animal> animals = new ArrayList<>();
    animalRepository.findAll().forEach(animal -> animals.add(animal));
    return animals;
  }

  public List<Animal> getAllAnimalsByOrigin(String placeOfOrigin){
    return animalRepository.findAll()
        .stream()
        .filter(animal -> animal.getPlaceOfOrigin().equals(placeOfOrigin))
        .collect(Collectors.toList());
  }

  public List<Animal> getAllAnimalsByDate(LocalDate dateOfArrival){
    return animalRepository.findAll()
        .stream()
        .filter(animal -> animal.getDateOfArrival().isEqual(dateOfArrival))
        .collect(Collectors.toList());
  }

  public void addAnimal(Animal animal){

    if (animalRepository.findById(animal.getRegistrationNo()).isPresent()){
      throw new IllegalArgumentException("Animal with this ID already exists.");
    }
    animalRepository.save(animal);
  }
}
