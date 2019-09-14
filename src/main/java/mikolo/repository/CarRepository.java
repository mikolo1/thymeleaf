package mikolo.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import mikolo.model.Car;

@Repository
public class CarRepository {
	
	private List<Car>startedCarList = Arrays.asList(
			new Car("Skoda", "Fabia"),
			new Car("Volkswagen", "Golf"),
			new Car("BMW", "M5"),
			new Car("Peugeot", "308"),
			new Car("Ford", "Focus"));
	
	private List<Car>allCars = new ArrayList<Car>(startedCarList);
	
	public List<Car>allCars(){
		addNrToCarList();
		return allCars;
	}
	
	public void addCar(Car car) {
		allCars.add(car);
	}
	
	public void deleteCar(int carId) {
		allCars.remove(carId - 1);
	}
	
	void addNrToCarList() {
		allCars.stream().forEach(c->c.setNr(Long.valueOf(allCars.indexOf(c))+1L));
	}
	
	public Car findByNr(int id) {
		addNrToCarList();
		return (allCars.get((id-1)));
	}

	public void editCar(Car car) {
		Car carToEdit = findByNr((car.getNr().intValue()));
		carToEdit.setMark(car.getMark());
		carToEdit.setModel(car.getModel());
	}
	
}
