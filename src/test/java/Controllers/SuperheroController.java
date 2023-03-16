package Controllers;

import DTO.Hero_DTO_City;
import DTO.Hero_DTO_CreationDate;
import DTO.Hero_DTO_Power_Count;
import DTO.Hero_DTO_Superpowers;
import Repositories.IRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;


import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("superhelte")
public class SuperheroController {

    IRepository repository;

    public SuperheroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl){
        repository = (IRepository) context.getBean(impl);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Hero_DTO_CreationDate>> getHeroesByHeroName(@PathVariable String name) throws SQLException {
        List<Hero_DTO_CreationDate> searchResults = repository.getSuperheroesName(name);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @GetMapping("/superpower/count/{name}")
    public ResponseEntity<List<Hero_DTO_Power_Count>> getSuperpowersCountByHeroName(@PathVariable String name) throws SQLException {
        List<Hero_DTO_Power_Count> superpowers = repository.getNumbrOfPowersName(name);
        return new ResponseEntity<>(superpowers, HttpStatus.OK);
    }

    @GetMapping("/superpower/{name}")
    public ResponseEntity<List<Hero_DTO_Superpowers>> getSuperpowersByHeroName(@PathVariable String name) {
        List<Hero_DTO_Superpowers> superpowers = repository.getSuperpowerName(name);
        return new ResponseEntity<>(superpowers, HttpStatus.OK);
    }

    @GetMapping("/city/{name}")
    public ResponseEntity<List<Hero_DTO_City>> getCityByHeroName(@PathVariable String name) {
        List<Hero_DTO_City> heroesAndCities = repository.getHeroCityName(name);
        return new ResponseEntity<>(heroesAndCities, HttpStatus.OK);
    }



}
