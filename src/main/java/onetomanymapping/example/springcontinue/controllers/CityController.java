package onetomanymapping.example.springcontinue.controllers;

import onetomanymapping.example.springcontinue.entities.City;
import onetomanymapping.example.springcontinue.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    private List<City> getAll() {
        return cityService.getAll();

    }

    @GetMapping("/{id}")
    private City getById(@PathVariable int id) {
        return cityService.getById(id);
    }

    @PostMapping
    private  City add(@RequestBody City city)
    {
        return  cityService.addOrUpdate(city);
    }
@PutMapping("/{id}")
private City update(@PathVariable int id , @RequestBody City city)
{
    city.setCityid(id);
    return  cityService.addOrUpdate(city);
}

@DeleteMapping("/{id}")
    private  void delete(@PathVariable int id )
{
    cityService.deleteById(id);
}
}