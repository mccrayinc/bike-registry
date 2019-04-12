package pe.cespiritu.demo.bikeregister.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.cespiritu.demo.bikeregister.models.Bike;
import pe.cespiritu.demo.bikeregister.repositories.BikeRepository;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> list() {
        return bikeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike) {
        bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") long id) {
        return bikeRepository.getOne(id);
    }

}
