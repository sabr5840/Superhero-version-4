package Repositories;

import DTO.Hero_DTO_City;
import DTO.Hero_DTO_Power_Count;
import DTO.Hero_DTO_CreationDate;
import DTO.Hero_DTO_Superpowers;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryJDBC implements IRepository  {

    //To implement following methods with JDBC, you must first establish a connection to your database using the JDBC API.
    String url = "jdbc:mysql://localhost:3306/Superhero_database"; // URL to the database
        String user = "root"; // Username for the database
        String password = "Tysontyson9"; // Password to the database
        Connection connection = DriverManager.getConnection(url, user, password);

    public RepositoryJDBC() throws SQLException {}

    //Shows all heroes from a superhero table
    @Override
    public List<Hero_DTO_CreationDate> getAllSuperheroes() throws SQLException {

        //Method performs a simple SELECT query and adds each row in the result to a list of Hero_DTO_CreationDate objects.

        List<Hero_DTO_CreationDate> heroes = new ArrayList<>();
        String query = "SELECT * FROM superhero";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Hero_DTO_CreationDate hero = new Hero_DTO_CreationDate(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("creation_date").toLocalDate()
            );
            heroes.add(hero);
        }
        return heroes;
    }

    //Show a specific superhero by name(heroname) search
    @Override
    public List<Hero_DTO_CreationDate> getSuperheroesName(String heroName) throws SQLException {

        //Method uses JDBC to connect to a database and execute a SELECT query with a WHERE clause to find a particular superhero's name.
        //The IRepository interface must be implemented using JDBC to retrieve data from this database

        List<Hero_DTO_CreationDate> heroes = new ArrayList<>();
        String query = "SELECT * FROM superhero WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, heroName);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Hero_DTO_CreationDate hero = new Hero_DTO_CreationDate(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("creation_date").toLocalDate()
            );
            heroes.add(hero);
        }
        return heroes;
    }


    //Show all heroes from superhero and amount of powers
    @Override
    public List<Hero_DTO_Power_Count> getNumberOfPowers() throws SQLException {
        List<Hero_DTO_Power_Count> heroes = new ArrayList<>();
        String query = "SELECT superhero_name, COUNT(*) as power_count FROM superhero_powers GROUP BY superhero_name";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String heroName = resultSet.getString("superhero_name");
                int powerCount = resultSet.getInt("power_count");
                Hero_DTO_Power_Count hero = new Hero_DTO_Power_Count(heroName, powerCount);
                heroes.add(hero);
            }
        }
        return heroes;
    }

    //Show a specific superhero and their amount of powers by name(heroname) search
    @Override
    public List<Hero_DTO_Power_Count> getNumbrOfPowersName(String heroName) throws SQLException {
        List<Hero_DTO_Power_Count> heroes = new ArrayList<>();
        String query = "SELECT superhero_name, COUNT(*) as power_count FROM superhero_powers WHERE superhero_name = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, heroName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int powerCount = resultSet.getInt("power_count");
                    Hero_DTO_Power_Count hero = new Hero_DTO_Power_Count(heroName, powerCount);
                    heroes.add(hero);
                }
            }
        }
        return heroes;
    }

    //Show all superheroes and their superpowers from table
    @Override
    public List<Hero_DTO_Superpowers> getSuperpower() {
        List<Hero_DTO_Superpowers> heroList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT superhero.name, superpower.power FROM superhero JOIN hero_superpower ON superhero.id = hero_superpower.hero_id JOIN superpower ON hero_superpower.power_id = superpower.id";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String power = resultSet.getString("power");
                heroList.add(new Hero_DTO_Superpowers(name, power));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return heroList;
    }

    //Show a specific hero and their superpowers by name search
    @Override
    public List<Hero_DTO_Superpowers> getSuperpowerName(String heroName) {
        List<Hero_DTO_Superpowers> heroList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT superhero.name, superpower.power FROM superhero JOIN hero_superpower ON superhero.id = hero_superpower.hero_id JOIN superpower ON hero_superpower.power_id = superpower.id WHERE superhero.name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, heroName);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String power = resultSet.getString("power");
                heroList.add(new Hero_DTO_Superpowers(name, power));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return heroList;
    }

    //Shows all heroes and which city they are from
    @Override
    public List<Hero_DTO_City> getHeroCity() {
        List<Hero_DTO_City> heroCityList = new ArrayList<>();
        try {
            // Establishing the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            // Creating a statement
            Statement statement = connection.createStatement();
            // SQL query for getting hero's name and city
            String query = "SELECT heroName, cityName FROM superhero JOIN city ON superhero.city_id = city.id";
            // Executing the query
            ResultSet resultSet = statement.executeQuery(query);
            // Iterating through the result set and creating Hero_DTO_City objects
            while (resultSet.next()) {
                Hero_DTO_City heroCity = new Hero_DTO_City();
                heroCity.setHeroName(resultSet.getString("heroName"));
                heroCity.setCity(resultSet.getString("cityName"));
                heroCityList.add(heroCity);
            }
            // Closing the connection, statement and result set
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroCityList;
    }

    //Show a specific hero and where they are from, by name search
    @Override
    public List<Hero_DTO_City> getHeroCityName(String heroName) {
        List<Hero_DTO_City> heroCityList = new ArrayList<>();
        try {
            // Establishing the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            // SQL query for getting hero's name and city by name search
            String query = "SELECT heroName, cityName FROM superhero JOIN city ON superhero.city_id = city.id WHERE heroName=?";
            // Creating a prepared statement and setting the parameter
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, heroName);
            // Executing the query
            ResultSet resultSet = preparedStatement.executeQuery();
            // Iterating through the result set and creating Hero_DTO_City objects
            while (resultSet.next()) {
                Hero_DTO_City heroCity = new Hero_DTO_City();
                heroCity.setHeroName(resultSet.getString("heroName"));
                heroCity.setCity(resultSet.getString("cityName"));
                heroCityList.add(heroCity);
            }
            // Closing the connection, prepared statement and result set
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroCityList;
    }
}
