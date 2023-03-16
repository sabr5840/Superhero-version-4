package Repositories;

import DTO.Hero_DTO_City;
import DTO.Hero_DTO_Power_Count;
import DTO.Hero_DTO_CreationDate;
import DTO.Hero_DTO_Superpowers;
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
    public List<Hero_DTO_CreationDate> getAllSuperheroes() {
        List<Hero_DTO_CreationDate> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            dtos.add(new Hero_DTO_CreationDate(superhero.getId(), superhero.getHeroName(), superhero.getCreationDate().getYear()));
        }
        return dtos;
    }

    @Override
    public List<Hero_DTO_CreationDate> getSuperheroesName(String heroName) {
        List<Hero_DTO_CreationDate> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                dtos.add(new Hero_DTO_CreationDate(superhero.getId(), superhero.getHeroName(), superhero.getCreationDate().getYear()));
            }
        }
        return dtos;
    }

    @Override
    public List<Hero_DTO_Power_Count> getNumberOfPowers() {
        List<Hero_DTO_Power_Count> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            dtos.add(new Hero_DTO_Power_Count(superhero.getHeroName(), superhero.getSuperpowers().size()));
        }
        return dtos;
    }

    @Override
    public List<Hero_DTO_Power_Count> getNumbrOfPowersName(String heroName) {
        List<Hero_DTO_Power_Count> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                dtos.add(new Hero_DTO_Power_Count(superhero.getHeroName(), superhero.getSuperpowers().size()));
            }
        }
        return dtos;
    }

    @Override
    public List<Hero_DTO_Superpowers> getSuperpower() {
        List<Hero_DTO_Superpowers> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            for (Superpower superpower : superhero.getSuperpowers()) {
                dtos.add(new Hero_DTO_Superpowers(superhero.getHeroName(), superpower.getName()));
            }
        }
        return dtos;
    }

    @Override
    public List<Hero_DTO_Superpowers> getSuperpowerName(String heroName) {
        List<Hero_DTO_Superpowers> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                for (Superpower superpower : superhero.getSuperpowers()) {
                    dtos.add(new Hero_DTO_Superpowers(superhero.getHeroName(), superpower.getName()));
                }
            }
        }
        return dtos;
    }

    @Override
    public List<Hero_DTO_City> getHeroCity() {
        List<Hero_DTO_City> result = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            result.add(new Hero_DTO_City(superhero.getHeroName(), superhero.getCity().getCityName()));
        }
        return result;
    }

    @Override
    public List<Hero_DTO_City> getHeroCityName(String heroName) {
        List<Hero_DTO_City> searchResult = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equals(heroName)) {
                searchResult.add(new Hero_DTO_City(superhero.getHeroName(), superhero.getCity().getName()));;
            }
        }

        return searchResult;

    }


}
