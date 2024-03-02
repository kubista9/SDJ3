package via.sdj3;

import org.json.JSONObject;
import via.sdj3.dao.DrinkDaoApi;
import via.sdj3.dao.ViaDrinkDAO;
import via.sdj3.model.DrinkDTO;

import java.util.Optional;

public class MainApp {
	private static DrinkDaoApi<DrinkDTO> drinkDao;

	public static void main(String[] args) throws Exception {
		//System.out.println("Hello world!");
		drinkDao = new ViaDrinkDAO();
		//get a drink
		DrinkDTO d1 = getDrink(0);

		JSONObject jo = new JSONObject(d1);
		System.out.println(d1.getName() + ", " + d1.getDescription());
		System.out.println("JSON " + jo);

		System.out.println("**** all drinks ****");
		drinkDao.getAll().forEach(drink -> System.out.println(
				drink.getName() + ", " + drink.getUnitPrice()
		));
	}

	private static DrinkDTO getDrink(long id) throws Exception{
		Optional<DrinkDTO> d = drinkDao.get(id);
		return d.orElseThrow(Exception::new);
	}
}
