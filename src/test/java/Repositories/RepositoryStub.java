package Repositories;

import DTO.SuperheroNameCityDTO;
import DTO.SuperheroNameRealNameNumberDTO;
import DTO.SuperheroNameRealNameYearDTO;
import DTO.SuperheroNameRealSuperpowerDTO;
import Model.Superhero;
import Model.Superpower;

import java.util.ArrayList;
import java.util.List;

//The purpose of having a RepositoryStub is to simulate data access and storage operations normally performed in a database in order to test and debug the application.
public class RepositoryStub implements IRepository {

    //Creates a private list of objects of type Superhero called "superheroes" and initializes it as an empty ArrayList.
    private List<Superhero> superheroes = new ArrayList<>();

    //Initializes a type of Repository-Stub object and adds a superhero objects to a list of superheroes
    public RepositoryStub() {
        superheroes.add(new Superhero("Scarlet Witch", "Wanda Maximoff", 1989, true, 3));
        superheroes.add(new Superhero("Captain Marvel", "Carol Danvers", 1938, true, 7));
        superheroes.add(new Superhero("Black Widow", "Natasha Romanoff", 1982, true, 2));
        superheroes.add(new Superhero("Spiderman", "Peter Parker", 1992, true, 7));
        superheroes.add(new Superhero("Captain America", "Steve Rogers", 1962, true, 5));
        superheroes.add(new Superhero("Thor", "Thor", 1000, false, 7));
        superheroes.add(new Superhero("Iron Man", "Tony Star", 1981, true, 5));
        superheroes.add(new Superhero("Mistress Love", "Love", 2012, false, 5));
    }

    //Represents the implementation of various methods in a RepositoryStub interface that provide access to a list of Superhero objects
    @Override
    public List<SuperheroNameRealNameYearDTO> getAllSuperheroes() {
        List<SuperheroNameRealNameYearDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            dtos.add(new SuperheroNameRealNameYearDTO(superhero.getHeroName(), superhero.getRealName(), superhero.getCreationDate().getYear()));
        }
        return dtos;
    }

    @Override
    public List<SuperheroNameRealNameYearDTO> getSuperheroesName(String heroName) {
        List<SuperheroNameRealNameYearDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                dtos.add(new SuperheroNameRealNameYearDTO(superhero.getHeroName(), superhero.getRealName(), superhero.getCreationDate().getYear()));
            }
        }
        return dtos;
    }

    @Override
    public List<SuperheroNameRealNameNumberDTO> getNumberOfPowers() {
        List<SuperheroNameRealNameNumberDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            dtos.add(new SuperheroNameRealNameNumberDTO(superhero.getHeroName(), superhero.getRealName(), superhero.getSuperpowers().size()));
        }
        return dtos;
    }

    @Override
    public List<SuperheroNameRealNameNumberDTO> getNumbrOfPowersName(String heroName) {
        List<SuperheroNameRealNameNumberDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                dtos.add(new SuperheroNameRealNameNumberDTO(superhero.getHeroName(), superhero.getRealName(), superhero.getSuperpowers().size()));
            }
        }
        return dtos;
    }

    @Override
    public List<SuperheroNameRealSuperpowerDTO> getSuperpower() {
        List<SuperheroNameRealSuperpowerDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            for (Superpower superpower : superhero.getSuperpowers()) {
                dtos.add(new SuperheroNameRealSuperpowerDTO(superhero.getHeroName(), superhero.getRealName(), superpower.getName()));
            }
        }
        return dtos;
    }

    @Override
    public List<SuperheroNameRealSuperpowerDTO> getSuperpowerName(String heroName) {
        List<SuperheroNameRealSuperpowerDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                for (Superpower superpower : superhero.getSuperpowers()) {
                    dtos.add(new SuperheroNameRealSuperpowerDTO(superhero.getHeroName(), superhero.getRealName(), superpower.getName()));
                }
            }
        }
        return dtos;
    }

    @Override
    public List<SuperheroNameCityDTO> getHeroCity() {
        List<SuperheroNameCityDTO> result = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            result.add(new SuperheroNameCityDTO(superhero.getHeroName(), superhero.getCity().getCityName()));
        }
        return result;
    }

    @Override
    public List<SuperheroNameCityDTO> getHeroCityName(String heroName) {
        List<SuperheroNameCityDTO> searchResult = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equals(heroName)) {
                searchResult.add(new SuperheroNameCityDTO(superhero.getHeroName(), superhero.getCity().getName()));;
            }
        }

        return searchResult;

    }


}
