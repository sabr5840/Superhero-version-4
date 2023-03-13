package DTO;

public class SuperheroNameRealNameNumberDTO {

    //Specific attributes that represent the desired data to be transferred
    private String heroName;
    private String realName;
    private int number_of_superpowers;

    //Constructor that accepts the desired attributes and creates a new instance of the DTO class
    public SuperheroNameRealNameNumberDTO(String heroName, String realName, int number_of_superpowers) {
        this.heroName = heroName;
        this.realName = realName;
        this.number_of_superpowers = number_of_superpowers;
    }

    //Getter and setter that allows the attributes to be accessed and updated
    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getNumber_of_superpowers() {
        return number_of_superpowers;
    }

    public void setNumber_of_superpowers(int number_of_superpowers) {
        this.number_of_superpowers = number_of_superpowers;
    }

}
