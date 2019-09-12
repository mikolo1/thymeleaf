package mikolo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mikolo.model.Car;

@Controller
public class CarController {
	
	@GetMapping({"", "car"})
	public String showCar(Model model) {
		Car car = new Car("Skoda", "Fabia");
		model.addAttribute("car", car);
		return "car";
	}
}
