package Repositories;

import DTO.Hero_DTO_City;
import DTO.Hero_DTO_Power_Count;
import DTO.Hero_DTO_CreationDate;
import DTO.Hero_DTO_Superpowers;

import java.sql.SQLException;
import java.util.List;

public interface IRepository{

    //De fire forskellige DTO'er, en for hver forespørgsel, og hver DTO indeholder forskellige felter, der repræsenterer de data, der skal returneres.
    //For hver forespørgsel defineres to metoder: en generel metode, der returnerer alle data, og en mere specifik metode, der kun returnerer data for en bestemt superhelt med et givet heroName.

    // Forespørgsel 1: En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder heroName, realName og creationYear
    List<Hero_DTO_CreationDate> getAllSuperheroes() throws SQLException;
    List<Hero_DTO_CreationDate> getSuperheroesName(String heroName) throws SQLException;

    // Forespørgsel 2: En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder heroName, realName og antallet af superkræfter (Superpower)
    List <Hero_DTO_Power_Count> getNumberOfPowers() throws SQLException;
    List <Hero_DTO_Power_Count> getNumbrOfPowersName(String heroName) throws SQLException;

    // Forespørgsel 3: En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder heroName, realName, superkræfter (Superpower)
    List<Hero_DTO_Superpowers> getSuperpower();
    List<Hero_DTO_Superpowers> getSuperpowerName(String heroName);

    // Forespørgsel 4: En superhelt med et bestemt heroName eller en liste med alle superhelte, der indeholder heroName og by (City)
    List<Hero_DTO_City> getHeroCity();
    List<Hero_DTO_City> getHeroCityName(String heroName);

}





















