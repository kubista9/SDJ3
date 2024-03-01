package via.sdj3.jparestfulexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import via.sdj3.jparestfulexample.entity.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
	//filter or extra: add the method here

}
