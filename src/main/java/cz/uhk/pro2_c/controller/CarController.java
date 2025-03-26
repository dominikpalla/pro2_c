package cz.uhk.pro2_c.controller;

import cz.uhk.pro2_c.model.Car;
import cz.uhk.pro2_c.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("cars", carService.getCars());
        return "cars_list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("car", new Car());
        return "cars_add";
    }

    @PostMapping("/add")
    public String addSave(@ModelAttribute Car car){
        carService.saveCar(car);
        return "redirect:/cars/";
    }

}
