package DTO;

public class Hero_DTO_Power_Count {

    //Specific attributes that represent the desired data to be transferred
    private String heroName;
    private int number_of_superpowers;

    //Constructor that accepts the desired attributes and creates a new instance of the DTO class
    public Hero_DTO_Power_Count(String heroName, int number_of_superpowers) {
        this.heroName = heroName;
        this.number_of_superpowers = number_of_superpowers;
    }

    //Getter and setter that allows the attributes to be accessed and updated
    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getNumber_of_superpowers() {
        return number_of_superpowers;
    }

    public void setNumber_of_superpowers(int number_of_superpowers) {
        this.number_of_superpowers = number_of_superpowers;
    }

}
