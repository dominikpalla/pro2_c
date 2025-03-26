package cz.uhk.pro2_c.service;

import cz.uhk.pro2_c.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CarService {
    List<Car> getCars();
    void saveCar(Car car);
}
