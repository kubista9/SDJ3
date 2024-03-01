package via.sdj3.slaughterhousepart2.service;

import org.springframework.stereotype.Service;
import via.sdj3.slaughterhousepart2.entity.Animal;
import via.sdj3.slaughterhousepart2.grpcClient.animal.AnimalClient;
import via.sdj3.slaughterhousepart2.repository.IAnimalRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService implements AnimalServiceInterface
{
  private final AnimalClient client;

  public AnimalService(AnimalClient animalClient){
    client = animalClient;
  }

  public Animal addAnimal(Animal animal){
      return client.addAnimal(animal);
  }
}
