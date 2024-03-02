package via.sdj3.dao;

import via.sdj3.model.DrinkDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ViaDrinkDAO implements DrinkDaoApi {

	// create an in memory storage
	List<DrinkDTO> viaDrinks = new ArrayList<>();

	public ViaDrinkDAO() {
		viaDrinks.add(new DrinkDTO("Orange Juice","It need to be clean",12.10, 1));
		viaDrinks.add(new DrinkDTO("Carlsberg beer","Chilled",25.25, 10));

	}

	@Override
	public Optional get(long id) {
		//return Optional.empty();
		return Optional.ofNullable(viaDrinks.get((int) id));
		//viaDrinks.stream().f
	}

	@Override
	public List getAll() {
		return viaDrinks;
	}

	@Override
	public void save(Object o) {

	}

	@Override
	public boolean update(long id, Object updated) {
		return false;
	}

	@Override
	public void update(Object o, String[] params, double price, int quantity) {

	}

	@Override
	public void delete(long id) {

	}
}
