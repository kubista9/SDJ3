package via.sdj3.grpcspringboot.frontend.repository;

import via.sdj3.grpcspringboot.frontend.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
