package DTO;

import java.time.LocalDate;

public class Hero_DTO_CreationDate {


    //Specific attributes that represent the desired data to be transferred
    private int id;
    private String heroName;
    private LocalDate creationDate;

    //Constructor that accepts the desired attributes and creates a new instance of the DTO class
    public Hero_DTO_CreationDate(int id, String heroName, int creationDate) {
        this.id = id;
        this.heroName = heroName;
        this.creationDate = LocalDate.ofEpochDay(creationDate);
    }


    //Getter and setter that allows the attributes to be accessed and updated
    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = LocalDate.ofEpochDay(creationDate);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
