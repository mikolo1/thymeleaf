package mikolo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import mikolo.model.Car;
import mikolo.repository.CarRepository;

@AllArgsConstructor
@Controller
public class CarController {
	
	private CarRepository carRepository;
	
	@GetMapping({"", "car"})
	public String showCar(Model model) {
		List<Car>carList = carRepository.allCars();
		model.addAttribute("car", new Car());
		model.addAttribute("cars", carList);
		return "car";
	}
	
	@PostMapping("addcar")
	public String addCar(@ModelAttribute Car car) {
		carRepository.addCar(car);
		return "redirect:car";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCar(@PathVariable("id") int carId) {
		carRepository.deleteCar(carId);
		return "redirect:../car";
	}
	
	@GetMapping("/edit/{id}")
	public String editCar(@PathVariable("id") int carId, Model model) {
		Car carToEdit = carRepository.findByNr(carId);
		model.addAttribute("car", carToEdit);
		return "editcar";
	}
	
	@PostMapping("/caredit")
	public String editCar(@ModelAttribute Car car) {
		carRepository.editCar(car);
		return "redirect:/car";
	}
}
