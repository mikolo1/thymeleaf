package mikolo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mikolo.model.Car;

@Controller
public class CarController {
	
	@GetMapping({"", "car"})
	public String showCar(Model model) {
		List<Car>carList = Arrays.asList(
		new Car("Skoda", "Fabia"),
		new Car("Volkswagen", "Golf"),
		new Car("BMW", "M5"),
		new Car("Peugeot", "308"),
		new Car("Ford", "Focus"));
	
		model.addAttribute("cars", carList);
		return "car";
	}
}
