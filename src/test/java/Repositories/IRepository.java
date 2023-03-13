package Repositories;

import DTO.SuperheroNameCityDTO;
import DTO.SuperheroNameRealNameNumberDTO;
import DTO.SuperheroNameRealNameYearDTO;
import DTO.SuperheroNameRealSuperpowerDTO;

import java.util.List;

public interface IRepository{

    //De fire forskellige DTO'er, en for hver forespørgsel, og hver DTO indeholder forskellige felter, der repræsenterer de data, der skal returneres.
    //For hver forespørgsel defineres to metoder: en generel metode, der returnerer alle data, og en mere specifik metode, der kun returnerer data for en bestemt superhelt med et givet heroName.

    // Forespørgsel 1: En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder heroName, realName og creationYear
    List<SuperheroNameRealNameYearDTO> getAllSuperheroes();
    List<SuperheroNameRealNameYearDTO> getSuperheroesName(String heroName);

    // Forespørgsel 2: En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder heroName, realName og antallet af superkræfter (Superpower)
    List <SuperheroNameRealNameNumberDTO> getNumberOfPowers();
    List <SuperheroNameRealNameNumberDTO> getNumbrOfPowersName(String heroName);

    // Forespørgsel 3: En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder heroName, realName, superkræfter (Superpower)
    List<SuperheroNameRealSuperpowerDTO> getSuperpower();
    List<SuperheroNameRealSuperpowerDTO> getSuperpowerName(String heroName);

    // Forespørgsel 4: En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder heroName og by (City)
    List<SuperheroNameCityDTO> getHeroCity();
    List<SuperheroNameCityDTO> getHeroCityName(String heroName);

}





















